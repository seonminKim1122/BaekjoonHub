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

        Queue<int[]> queue = new LinkedList<>();

        int[][] area = new int[N][M];
        int[][] visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = N * M;
                if (area[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = 0;
                }
            }
        }

        int[] dx = {1, -1, 0, 0, -1, 1, -1, 1};
        int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};

        int result = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            int x = now[0];
            int y = now[1];
            int dist = visited[x][y];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (dist + 1 >= visited[nx][ny]) continue;

                queue.add(new int[]{nx, ny});
                visited[nx][ny] = dist + 1;
                result = Math.max(result, visited[nx][ny]);
            }
        }

        System.out.println(result);
    }
}