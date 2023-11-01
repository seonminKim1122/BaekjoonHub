import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int size = Math.abs(H - N) + 1;
        long[][] dp = new long[size][size];
        dp[0][0] = 1;

        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        System.out.println(dp[size - 1][size - 1]);
    }
}