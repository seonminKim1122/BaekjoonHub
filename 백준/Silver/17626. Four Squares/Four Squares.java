import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sqrt = (int)Math.sqrt(i);
            if (Math.sqrt(i) == sqrt) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i-1] + dp[1];
                for (int j = 2; j <= sqrt; j++) {
                    dp[i] = Math.min(dp[i - (j*j)] + dp[j*j], dp[i]);
                }
            }
        }
        System.out.println(dp[n]);
    }
}