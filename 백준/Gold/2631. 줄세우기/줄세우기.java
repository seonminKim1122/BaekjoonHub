import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] children = new int[N + 1];
        for (int i = 0; i < N; i++) {
            int child = Integer.parseInt(br.readLine());
            children[i + 1] = child;
        }

        int[] dp = new int[N + 1];
        dp[0] = 1;

        int result = 0;
        for (int i = 1; i <= N; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 1; j--) {
                if (children[i] > children[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }

        System.out.println(N - result);
    }
}