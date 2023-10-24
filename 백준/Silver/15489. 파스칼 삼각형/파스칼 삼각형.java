import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] dp = new int[R + W][C + W + 1];
        dp[1][1] = 1;

        for (int i = 2; i < R + W; i++) {
            for (int j = 1; j <= C + W; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        int result = 0;
        for (int i = 0; i < W; i++) {
            for (int j = 0; j <= i; j++) {
                result += dp[R + i][C + j];
            }
        }

        System.out.println(result);
    }
}