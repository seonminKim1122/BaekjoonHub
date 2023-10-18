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
        dp = new int[N + 1][N + 1];
        numbers = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], -1);
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            sb.append(dp(S, E)).append("\n");
        }

        System.out.println(sb);
    }

    public static int dp(int S, int E) {
        if (dp[S][E] != -1) return dp[S][E];

        if (S >= E) {
            dp[S][E] = 1;
        } else {
            if (numbers[S] != numbers[E]) {
                dp[S][E] = 0;
            } else {
                dp[S][E] = dp(S + 1, E - 1);
            }
        }

        return dp[S][E];
    }
}