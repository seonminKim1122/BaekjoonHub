import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[3][N][N];
        /*
        0: 가로 모양으로 i, j 에 오는 경우의 수
        1: 세로 모양으로 i, j 에 오는 경우의 수
        2: 대가선 모양으로 i, j 에 오는 경우의 수

        dp[0][i][j] = dp[0][i][j - 1] + dp[2][i][j - 1];
        dp[1][i][j] = dp[1][i - 1][j] + dp[2][i - 1][j];
        dp[2][i][j] = dp[0][i - 1][j - 1] + dp[1][i - 1][j - 1] + dp[2][i - 1][j - 1];
         */
        for (int j = 1; j < N; j++) {
            if (map[0][j] == 1) break;
            dp[0][0][j] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 대각선
                if (j - 1 >= 0 && (map[i][j] + map[i - 1][j] + map[i][j - 1] == 0)) {
                    dp[2][i][j] = dp[0][i - 1][j - 1] + dp[1][i - 1][j - 1] + dp[2][i - 1][j - 1];
                }
                // 가로
                if (j - 1 >= 0 && map[i][j] != 1) {
                    dp[0][i][j] = dp[0][i][j - 1] + dp[2][i][j - 1];
                }
                // 세로
                if (map[i][j] != 1) {
                    dp[1][i][j] = dp[1][i - 1][j] + dp[2][i - 1][j];
                }
            }
        }

        System.out.println(dp[0][N - 1][N - 1] + dp[1][N - 1][N - 1] + dp[2][N - 1][N - 1]);
    }
}