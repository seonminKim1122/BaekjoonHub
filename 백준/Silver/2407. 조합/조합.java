import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger[] dp = new BigInteger[m + 1];
        dp[1] = new BigInteger(String.valueOf(n));

        for (int i = 2; i <= m; i++) {
            dp[i] = dp[i - 1].multiply(new BigInteger(String.valueOf(n - i + 1))).divide(new BigInteger(String.valueOf(i)));
        }

        System.out.println(dp[m]);
    }
}