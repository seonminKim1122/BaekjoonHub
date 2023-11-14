import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] snacks = new int[N];
        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(br.readLine());
        }

        int[] dp  = new int[N];
        dp[0] = snacks[0];

        int result = 0;
        for (int i = 1; i < N; i++) {
            dp[i] = snacks[i];
            for (int j = 0; j < i; j++) {
                if (snacks[i] > snacks[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + snacks[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}