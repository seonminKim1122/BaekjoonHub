import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 계단의 갯수

        int[] dp = new int[N+1];
        int[] scores = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            int score = Integer.parseInt(br.readLine());
            scores[i] = score;
            if (i <= 2) {
                dp[i] = dp[i-1] + score;
                continue;
            }
            // i-1 번째 score :
            if (dp[i-3] + scores[i-1] > dp[i-2]) { // i-3 => i-1 => i vs i-2 => i
                dp[i] = dp[i-3] + scores[i-1] + score;
            } else {
                dp[i] = dp[i-2] + score;
            }
        }
        System.out.println(dp[N]);
    }
}