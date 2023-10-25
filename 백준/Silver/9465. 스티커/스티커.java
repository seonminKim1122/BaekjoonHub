import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n + 1];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {
                    stickers[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][n + 1];
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            int result = Math.max(dp[0][1], dp[1][1]);
            for (int k = 2; k <= n; k++) {
                for (int j = 0; j < 2; j++) {
                    dp[j][k] = Math.max(Math.max(dp[(j + 1) % 2][k - 1], dp[(j + 1) % 2][k - 2]), dp[j][k - 2]) + stickers[j][k];
                    result = Math.max(result, dp[j][k]);
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}