import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] += Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[N][M][3];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0) {
                    dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = arr[i][j];
                } else {

                    if (j+1 < M) {
                        dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + arr[i][j];
                    } else {
                        dp[i][j][0] = 100001;
                    }
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i][j];
                    if (j-1 >= 0) {
                        dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + arr[i][j];
                    } else {
                        dp[i][j][2] = 100001;
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                result = Math.min(result, dp[N-1][i][j]);
            }
        }

        System.out.println(result);
    }
}