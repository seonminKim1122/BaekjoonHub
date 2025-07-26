import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 1000 * 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(solve(map, N, M));
    }

    static int solve(char[][] map, int N, int M) {
        int[][][] cost = new int[2][N][M];
        for (int d = 0; d < 2; d++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    cost[d][i][j] = INF;
                }
            }
        }
        /*
        cost[0][i][j] -> 벽을 하나도 안 부수고 i, j 에 도달한 경우의 최소 비용
        cost[1][i][j] -> 이전에 벽을 한개 부수고 i, j 에 도달한 경우의 최소 비용
         */
        cost[0][0][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            int breakWall = now[0];
            int y = now[1];
            int x = now[2];


            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;

                if (map[ny][nx] == '0') {
                    if (cost[breakWall][ny][nx] > cost[breakWall][y][x] + 1) {
                        cost[breakWall][ny][nx] = cost[breakWall][y][x] + 1;
                        queue.add(new int[]{breakWall, ny, nx});
                    }
                } else if (breakWall == 0){
                    if (cost[1][ny][nx] > cost[0][y][x] + 1) {
                        cost[1][ny][nx] = cost[0][y][x] + 1;
                        queue.add(new int[]{1, ny, nx});
                    }
                }
            }
        }

        int result = Math.min(cost[0][N - 1][M - 1], cost[1][N - 1][M - 1]);
        return result == INF ? -1 : result + 1;
    }
}