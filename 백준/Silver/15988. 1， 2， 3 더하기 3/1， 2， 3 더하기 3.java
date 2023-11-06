import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[1000001];
        dp[1] = dp[0] = 1;
        dp[2] = 2;
        for (int i = 3; i <= 1000000; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % 1_000_000_009 + dp[i - 3]) % 1_000_000_009;
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < T; i++) {
            result.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }
        result.setLength(result.length() - 1);

        System.out.println(result);
    }
}