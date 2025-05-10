import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T > 0) {
            int n = Integer.parseInt(br.readLine());

            if (n == 1) {
                bw.write("1");
                bw.write("\n");
                T--;
                continue;
            }

            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }


            bw.write(String.valueOf(dp[n]));
            bw.write("\n");

            T--;
        }

        bw.flush();
        bw.close();
        br.close();
    }

}