import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    dist[i][j] = 1;
                }
            }
        }

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int k = 0; k < 4; k++) {
                int ny = now[0] + dy[k];
                int nx = now[1] + dx[k];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (map[ny][nx] == 0 || dist[ny][nx] != 0) continue;

                queue.add(new int[]{ny, nx});
                dist[ny][nx] = dist[now[0]][now[1]] + 1;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] == 0) {
                    answer.append(map[i][j] == 0 ? 0 : -1).append(" ");
                } else {
                    answer.append(dist[i][j] - 1).append(" ");
                }
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }


}