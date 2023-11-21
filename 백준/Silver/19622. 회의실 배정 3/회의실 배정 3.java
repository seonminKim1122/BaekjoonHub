import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            int people = Integer.parseInt(input[2]);

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + people;
        }

        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }
}