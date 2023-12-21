import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited;
    static int[][] pixels;
    static int N;
    static int M;


    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        pixels = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int sum = 0;
                for (int k = 0; k < 3; k++) {
                    sum += Integer.parseInt(st.nextToken());
                }
                pixels[i][j] = sum;
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (pixels[i][j] >= 3 * T) {
                    pixels[i][j] = 255;
                } else {
                    pixels[i][j] = 0;
                }
            }
        }

        visited = new boolean[N][M];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (pixels[i][j] == 255 && !visited[i][j]) {
                    dfs(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    public static void dfs (int i, int j) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || y < 0 || x >= N || y >= M || visited[x][y]) continue;
            if (pixels[x][y] == 0) continue;

            dfs(x, y);
        }
    }
}