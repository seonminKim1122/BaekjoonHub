import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 지폐의 금액
        int k = Integer.parseInt(br.readLine()); // 동전의 개수

        int[][] dp = new int[k + 1][T + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int coin = Integer.parseInt(st.nextToken());
            int numOfCoin = Integer.parseInt(st.nextToken());

            dp[i][0] = 1;

            for (int j = 1; j <= T; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int n= 1; n <= numOfCoin; n++) {
                    if (j - coin * n >= 0) {
                        dp[i][j] += dp[i - 1][j - coin * n];
                    }
                }
            }
        }

        System.out.println(dp[k][T]);
    }
}