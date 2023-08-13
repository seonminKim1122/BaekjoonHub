import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] relations = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int person1 = Integer.parseInt(st.nextToken());
            int person2 = Integer.parseInt(st.nextToken());
            relations[person1][person2] = 1;
            relations[person2][person1] = 1;
        }

        int min = 6 * N;
        int result = 0;
        for (int i = 1; i < N+1; i++) {
            int d = kevinBacon(relations, i);
            if (d < min) {
                min = d;
                result = i;
            }
        }

        System.out.println(result);
    }

    public static int kevinBacon(int[][] relations, int user) {
        int N = relations.length;
        boolean[] visited = new boolean[N];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{user, 0});
        visited[user] = true;

        int result = 0;
        while (!queue.isEmpty()) {
            int[] from = queue.poll();
            result += from[1];

            for (int to = 1; to < N; to++) {
                if (relations[from[0]][to] == 1 && !visited[to]) {
                    queue.add(new int[]{to, from[1]+1});
                    visited[to] = true;
                }
            }
        }
        return result;
    }
}