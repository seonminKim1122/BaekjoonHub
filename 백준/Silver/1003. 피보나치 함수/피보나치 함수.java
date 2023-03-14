import java.io.*;

public class Main {

    static int[] dp = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 기본값 셋팅
        dp[0] = 1;
        dp[1] = 1;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                bw.write("1 0\n");
            } else if (N == 1) {
                bw.write("0 1\n");
            } else {
                bw.write(fibo(N-2) + " " + fibo(N-1) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int fibo(int N) {
        if (dp[N] > 0) {
            return dp[N];
        }

        dp[N] = fibo(N-1) + fibo(N-2);
        return dp[N];
    }
}