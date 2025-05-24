import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while (T > 0) {
            T--;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] land = new int[N][M];
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());

                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                land[Y][X] = 1;
            }

            int result = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (land[y][x] == 0) continue;

                    dfs(land, y, x, N, M);
                    result++;
                }
            }

            answer.append(result).append("\n");
        }

        System.out.println(answer) ;
    }

    public static void dfs(int[][] land, int y, int x, int N, int M) {
        land[y][x] = 0;

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                continue;
            }
            if (land[ny][nx] == 0) continue;

            dfs(land, ny, nx, N, M);
        }
    }
}