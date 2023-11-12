import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = 2 * dp[i - 1];

            if (i - 4 >= 0 && (i - 3) % 2 == 1) {
                dp[i] -= dp[i - 4];
            }

            if (i - 5 >= 0 && (i - 4) % 2 == 0) {
                dp[i] -= dp[i - 5];
            }
        }

        System.out.println(dp[N]);
    }
}