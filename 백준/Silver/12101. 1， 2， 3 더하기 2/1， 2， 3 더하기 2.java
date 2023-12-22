import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String result = "";
    static int[] dp;
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[Math.max(n + 1, 3)];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]);
        }

        if (k > dp[n]) {
            System.out.println(-1);
        } else {
            findAnswer();
            System.out.println(result);
        }
    }

    public static void findAnswer() {
        if (n <= 0) {
            result = result.substring(0, result.length() - 1);
            return;
        }

        if (k <= dp[n - 1]) {
            result += "1+";
            n -= 1;
            findAnswer();
        } else if (k <= dp[n - 1] + dp[n - 2]) {
            result += "2+";
            k -= dp[n - 1];
            n -= 2;
            findAnswer();
        } else {
            result += "3+";
            k -= (dp[n - 1] + dp[n - 2]);
            n -= 3;
            findAnswer();
        }
    }
}