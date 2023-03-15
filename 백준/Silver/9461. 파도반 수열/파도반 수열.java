import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        // 초기값 셋팅
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        int last = 4;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            if (dp[N] == 0) {
                // dp[N] = dp[N-1] + dp[N-5];
                for (int j = last+1; j < N+1; j++) {
                    dp[j] = dp[j-1] + dp[j-5];
                }
                last = N;
            }
            bw.write(dp[N] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}