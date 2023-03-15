import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] costs = new int[N+1][3];
        int[][] dp = new int[1001][3];

        for (int i = 1; i < N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int costOfRed = Integer.parseInt(st.nextToken());
            int costOfGreen = Integer.parseInt(st.nextToken());
            int costOfBlue = Integer.parseInt(st.nextToken());

            costs[i][0] = costOfRed;
            costs[i][1] = costOfGreen;
            costs[i][2] = costOfBlue;

            // dp[i][0] = Min(dp[i-1][1], dp[i-1][2]) + costs[i][0]
            // dp[i][1] = Min(dp[i-1][0], dp[i-1][2]) + costs[i][1]
            // dp[i][2] = Min(dp[i-1][0], dp[i-1][1]) + costs[i][2]

            if (i == 1) {
                dp[i][0] = costs[i][0];
                dp[i][1] = costs[i][1];
                dp[i][2] = costs[i][2];
                continue;
            }

            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
        }
        System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
    }
}