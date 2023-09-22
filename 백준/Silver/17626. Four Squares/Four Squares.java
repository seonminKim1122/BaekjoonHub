import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            double sqrt = Math.sqrt(i);
            if ((int)sqrt == sqrt) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i - 1] + dp[1];
                for (int j = 2; j <= sqrt; j++) {
                    dp[i] = Math.min(dp[i - j * j] + dp[j * j], dp[i]);
                }
            }
        }

        System.out.println(dp[n]);
    }
}