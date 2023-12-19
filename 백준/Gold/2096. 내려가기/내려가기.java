import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] numbers = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                numbers[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] dp = new int[N][3];

        dp[0] = numbers[0];

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]) + numbers[i][0];
            dp[i][1] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]) + numbers[i][1];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]) + numbers[i][2];
        }

        int max = Math.max(Math.max(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]);

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + numbers[i][0];
            dp[i][1] = Math.min(Math.min(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]) + numbers[i][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + numbers[i][2];
        }

        int min = Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]);

        System.out.println(max + " " + min);
    }
}