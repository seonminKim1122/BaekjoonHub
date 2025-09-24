import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] row = new int[N];
        int[] col = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            row[i] = r;
            col[i] = c;
        }

        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }


        for (int len = 2; len <= N; len++) {
            for (int i = 0; i + len - 1 < N; i++) {
                int j = i + len - 1;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + row[i] * col[k] * col[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        System.out.println(dp[0][N - 1]);
    }
}