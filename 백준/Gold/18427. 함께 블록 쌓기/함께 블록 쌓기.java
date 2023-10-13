import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][H + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= H; j++) {
                dp[i][j] = dp[i - 1][j];
            }

            String[] input = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                int h = Integer.parseInt(input[j]);

                for (int k = h; k <= H; k++) {
                    dp[i][k] += dp[i - 1][k - h] % 10007;
                }
            }

        }

        System.out.println(dp[N][H] % 10007);
    }
}