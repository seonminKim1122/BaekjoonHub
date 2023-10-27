import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] numbers = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[N + 1];
            int result = Integer.MIN_VALUE;
            for (int i = 1; i <= N; i++) {
                dp[i] = Math.max(dp[i - 1], 0) + numbers[i];
                result = Math.max(result, dp[i]);
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}