import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder results = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] coins = new int[N];
            for (int j = 0; j < N; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            int[] dp = new int[M + 1];
            dp[0] = 1;
            for (int j = 0; j < N; j++) {
                int coin = coins[j];

                for (int k = coin; k <= M; k++) {
                    dp[k] = dp[k] + dp[k - coin];
                }
            }

            results.append(dp[M]).append("\n");
        }

        System.out.println(results);
    }
}