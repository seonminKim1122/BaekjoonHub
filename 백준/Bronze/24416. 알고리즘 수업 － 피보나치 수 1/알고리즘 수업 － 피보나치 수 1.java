import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int answer1 = 0;
    static int answer2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        fibonacci(n);
        fibonacci2(n);
        System.out.print(answer1 + " " + answer2);
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            answer1++;
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fibonacci2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            answer2++;
        }

        return dp[n];
    }
}