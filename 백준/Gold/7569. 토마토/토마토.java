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

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] box = new int[H][N][M];
        Queue<int[]> queue = new LinkedList<>();
        int[][][] visit = new int[H][N][M];
         for (int h = 0; h < H; h++) {
             for (int n = 0; n < N; n++) {
                 st = new StringTokenizer(br.readLine());
                 for (int m = 0; m < M; m++) {
                     box[h][n][m] = Integer.parseInt(st.nextToken());
                     visit[h][n][m] = -1;
                     if (box[h][n][m] == 1) {
                         queue.add(new int[]{h, n, m});
                         visit[h][n][m] = 0;
                     }
                 }
             }
         }



         int[] dz = {-1, 1, 0, 0, 0, 0};
         int[] dy = {0, 0, -1, 1, 0, 0};
         int[] dx = {0, 0, 0, 0, -1, 1};

         while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int k = 0; k < 6; k++) {
                int nz = now[0] + dz[k];
                int ny = now[1] + dy[k];
                int nx = now[2] + dx[k];

                if (nz < 0 || ny < 0 || nx < 0 || nz >= H || ny >= N || nx >= M) continue;
                if (visit[nz][ny][nx] != -1 || box[nz][ny][nx] == -1) continue;

                queue.add(new int[]{nz, ny, nx});
                visit[nz][ny][nx] = visit[now[0]][now[1]][now[2]] + 1;
            }
         }

         int answer = 0;
         for (int h = 0; h < H; h++) {
             for (int n = 0; n < N; n++) {
                 for (int m = 0; m < M; m++) {
                     if (box[h][n][m] != -1 && visit[h][n][m] == -1) {
                         System.out.println(-1);
                         return;
                     }

                     answer = Math.max(answer, visit[h][n][m]);
                 }
             }
         }

        System.out.println(answer);
    }

}
