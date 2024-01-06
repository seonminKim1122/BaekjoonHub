import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][] questions = new int[T][2];
        int R = 0;
        int C = 0;
        for (int t = 0; t < T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            questions[t][0] = Integer.parseInt(st.nextToken());
            questions[t][1] = Integer.parseInt(st.nextToken());

            R = Math.max(R, questions[t][0]);
            C = Math.max(C, questions[t][0]);
        }

        int[][] dp = new int[R + 1][Math.max(C + 1, 4)];
        dp[1][1] = dp[2][1] = dp[3][1] = 1;
        dp[2][2] = dp[3][3] = 1;
        dp[3][2] = 2;

        for (int i = 4; i <= R; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = ((dp[i - 1][j - 1] + dp[i - 2][j - 1]) % 1_000_000_009 + dp[i - 3][j - 1]) % 1_000_000_009;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = questions[t][0];
            int m = questions[t][1];
            result.append(dp[n][m]).append("\n");
        }
        result.setLength(result.length() - 1);
        
        System.out.println(result);
    }
}