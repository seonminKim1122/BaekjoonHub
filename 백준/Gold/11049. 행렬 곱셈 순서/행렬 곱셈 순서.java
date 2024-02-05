import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] R = new int[N];
        int[] C = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            R[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }

        for (int j = 1; j < N; j++) {
            for (int i = j - 1; i >= 0; i--) {
                for (int x = 1; x <= j - i ; x++) {
                    int v1 = dp[i + x][j] + dp[i][j - (j - i + 1 - x)] + (R[i] * R[i + x] * C[j]);
                    int v2 = dp[i][j - x] + dp[i + (j - i + 1 - x)][j] + (R[i] * C[j - x] * C[j]);
                    int v = Math.min(v1, v2);
                    dp[i][j] = Math.min(dp[i][j], v);
                }
            }
        }

        System.out.println(dp[0][N - 1]);
    }
}