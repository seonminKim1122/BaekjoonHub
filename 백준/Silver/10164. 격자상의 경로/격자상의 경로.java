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
        int K = Integer.parseInt(st.nextToken());

        if (K == 0) K = N * M;

        int[][] dp = new int[N][M];
        dp[0][0] = 1;

        int row = (K - 1) / M;
        int col = (K - 1) % M;

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                if (i + 1 <= row) {
                    dp[i + 1][j] += dp[i][j];
                }

                if (j + 1 <= col) {
                    dp[i][j + 1] += dp[i][j];
                }
            }
        }

        for (int i = row; i < N; i++) {
            for (int j = col; j < M; j++) {
                if (i + 1 < N) {
                    dp[i + 1][j] += dp[i][j];
                }
                if (j + 1 < M) {
                    dp[i][j + 1] += dp[i][j];
                }
            }
        }

        System.out.println(dp[N-1][M-1]);
    }
}