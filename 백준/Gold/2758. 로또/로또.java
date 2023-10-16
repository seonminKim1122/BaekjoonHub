import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        long[][] dp = new long[11][2001];

        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 2000; j++) {
                dp[i][j] = dp[i - 1][j / 2] + dp[i][j - 1];
            }
        }

        StringBuilder results = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            results.append(dp[n][m]).append("\n");
        }

        System.out.println(results);
    }
}