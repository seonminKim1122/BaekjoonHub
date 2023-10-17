import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] numbers;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        numbers = new int[N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], -1);
        }

        int result = dp(0, N - 1);
        System.out.println(result);
    }

    public static int dp(int i, int j) {
        if (i >= j) {
            dp[i][j] = 0;
        }

        if (dp[i][j] != -1) { // 값을 한 번 구했다면 추가 재귀 필요 X
            return dp[i][j];
        }

        if (numbers[i] == numbers[j]) {
            dp[i][j] = dp(i + 1, j - 1);
        } else {
            dp[i][j] = Math.min(dp(i + 1, j), dp(i, j - 1)) + 1;
        }

        return dp[i][j];
    }
}