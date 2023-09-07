import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Main {

    static boolean[][] roads;
    static int N;
    static int M;

    static int min = Integer.MAX_VALUE;
    static int chicken1 = 0;
    static int chicken2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        roads = new boolean[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            roads[A][B] = true;
            roads[B][A] = true;
        }

        for (int i = 1; i < N; i++) {
            for (int j = i+1; j < N+1; j++) {
                int time = roundTripTime(i, j);

                if (min > time) {
                    min = time;
                    chicken1 = i;
                    chicken2 = j;
                }
            }
        }

        System.out.println(chicken1 + " " + chicken2 + " " + min);
    }

    public static int roundTripTime(int chicken1, int chicken2) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        queue.add(new int[]{chicken1, 0});
        queue.add(new int[]{chicken2, 0});
        visited[chicken1] = true;
        visited[chicken2] = true;

        int result = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            result += now[1];
            for (int i = 1; i < N+1; i++) {
                if (roads[now[0]][i] && !visited[i]) {
                    queue.add(new int[]{i, now[1] + 1});
                    visited[i] = true;
                }
            }
        }

        return result * 2;
    }
}