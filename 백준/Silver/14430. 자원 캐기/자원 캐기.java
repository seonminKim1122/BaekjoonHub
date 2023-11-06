import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] ores = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][M];
        dp[0][0] = ores[0][0];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i + 1 < N) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + ores[i + 1][j]);
                }
                if (j + 1 < M) {
                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j] + ores[i][j + 1]);
                }
            }
        }

        System.out.println(dp[N - 1][M - 1]);
    }
}