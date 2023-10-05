import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] schedules = new int[N + 1][2]; // 0 : 소요 시간, 1 : 이익

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                schedules[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            if (i - 1 + schedules[i][0] > N) continue;
            dp[i - 1 + schedules[i][0]] = Math.max(dp[i - 1 + schedules[i][0]], dp[i - 1] + schedules[i][1]);
        }

        System.out.println(dp[N]);
    }
}