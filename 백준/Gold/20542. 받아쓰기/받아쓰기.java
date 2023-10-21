import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        String input = br.readLine();
        String answer = br.readLine();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char c1 = input.charAt(i - 1);
                char c2 = answer.charAt(j - 1);

                if (c1 == c2 || (c1 == 'i' && (c2 == 'j' || c2 == 'l')) || (c1 == 'v' && c2 == 'w')) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i-1][j-1]) + 1;
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}