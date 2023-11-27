import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[122];
        int[] b = new int[122];
        a[1] = 1;
        b[1] = 1;
        for (int i = 2; i < 122; i++) {
            a[i] = a[i - 1] + i;
            b[i] = a[i] + b[i - 1];
        }

        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < 122; j++) {
                if (i - b[j] < 0) break;
                dp[i] = Math.min(dp[i], dp[i - b[j]] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}