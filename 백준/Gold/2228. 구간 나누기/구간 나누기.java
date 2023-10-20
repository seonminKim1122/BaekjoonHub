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

        int[] numbers = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int number = Integer.parseInt(br.readLine());
            numbers[i] = number;
        }

        int[][] dp = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {

            for (int j = 2 * i - 1; j <= N; j++) {
                if (j == 2 * i - 1 && j - 1 >= 1) {
                    dp[i][j - 1] = -32768 * 100 - 1;
                }

                dp[i][j] = dp[i][j - 1];
                int min = Math.max(2 * i - 3, 0);
                for (int k = j - 2; k >= min; k--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k]);
                }
                dp[i][j] += numbers[j];
            }

            dp[i][2 * i - 2] = 0;
        }

        int result = Integer.MIN_VALUE;
        for (int i = 2 * M - 1; i <= N; i++) {
            result = Math.max(result, dp[M][i]);
        }

        System.out.println(result);
    }
}