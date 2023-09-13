import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    static int[][]  map;
    static boolean[][][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == N - 1 && now[1] == M - 1) {
                System.out.println(now[2]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x < 0 || y < 0 || x >= N || y >= M) continue;

                if (map[x][y] == 1) {
                    if (now[3] == 0 && !visited[x][y][1]) {
                        queue.add(new int[]{x, y, now[2] + 1, 1});
                        visited[x][y][1] = true;
                    }
                } else {
                    if (!visited[x][y][now[3]]) {
                        queue.add(new int[]{x, y, now[2] + 1, now[3]});
                        visited[x][y][now[3]] = true;
                    }
                }
            }
        }

        System.out.println(-1);
    }
}