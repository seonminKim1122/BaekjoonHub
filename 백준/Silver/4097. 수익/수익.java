import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder results = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) break;

            int[] dp = new int[N + 1];
            int result = Integer.MIN_VALUE;
            for (int i = 1; i <= N; i++) {
                int P = Integer.parseInt(br.readLine());
                dp[i] = Math.max(P, dp[i - 1] + P);
                result = Math.max(result, dp[i]);
            }

            results.append(result).append("\n");
        }

        System.out.println(results);
    }
}