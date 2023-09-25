import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        dp[0] = numbers[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(0, dp[i - 1]) + numbers[i];
        }

        int result = dp[0];
        for (int i = 1; i < n; i++) {
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}