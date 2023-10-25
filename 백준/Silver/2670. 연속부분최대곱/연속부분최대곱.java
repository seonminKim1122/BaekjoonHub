import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        double[] numbers = new double[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Double.parseDouble(br.readLine());
        }

        double[] dp = new double[N];
        dp[0] = numbers[0];

        double result = dp[0];
        for (int i = 1; i < N; i++) {
            dp[i] = (dp[i - 1] < 1) ? numbers[i] : dp[i - 1] * numbers[i];
            result = Math.max(result, dp[i]);
        }
        System.out.printf("%.3f", result);
//        System.out.println(Math.round(result * 1000) / 1000d);
    }
}