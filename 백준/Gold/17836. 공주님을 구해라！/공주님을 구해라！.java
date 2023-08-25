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
        int T = Integer.parseInt(st.nextToken());

        int[][] castle = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0}); // i, j, distance, 그람 보유(0 -> X, 1 -> O)
        boolean[][][] visited = new boolean[2][N][M];
        visited[0][0][0] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            if (curr[2] > T) break;
            
            if (curr[0] == N-1 && curr[1] == M-1) {
                System.out.println(curr[2]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int x = curr[0] + dx[i];
                int y = curr[1] + dy[i];

                if (x < 0 || y < 0 || x >= N || y >= M || visited[curr[3]][x][y]) continue;

                if (curr[3] == 1) { // 명검 그람 보유 시
                    queue.add(new int[]{x, y, curr[2] + 1, curr[3]});
                    visited[curr[3]][x][y] = true;
                } else { // 명검 그람 미보유 시
                    if (castle[x][y] == 1) continue;

                    if (castle[x][y] == 2) { // 명검 그람 있는 곳
                        queue.add(new int[]{x, y, curr[2] + 1, 1});
                        visited[0][x][y] = true;
                    } else {
                        queue.add(new int[]{x, y, curr[2] + 1, curr[3]});
                        visited[curr[3]][x][y] = true;
                    }
                }
            }
        }

        System.out.println("Fail");
    }
}