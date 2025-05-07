import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        /*
        1 x 2, 2 x 1, 2 x 2 로 2 x n 만들기

        => 2 x (n - 2) + (2 x 2)
        => 2 x (n - 2) + 2 * (1 x 2)
        => 2 x (n - 1) + (2 x 1)
         */

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (2 * dp[i - 2]) % 10007 + dp[i - 1] % 10007;
            dp[i] = dp[i] % 10007;
        }

        System.out.println(dp[n]);
    }
}