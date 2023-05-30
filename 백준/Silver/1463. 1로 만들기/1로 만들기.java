import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[1000001];
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= N; i++) {
            if (i % 3 == 0 && i % 2 == 0) {
                dp[i] = Math.min(Math.min(dp[i/3], dp[i/2]), dp[i-1])+1;
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i/2], dp[i-1])+1;
            } else if (i % 3 == 0 ) {
                dp[i] = Math.min(dp[i/3], dp[i-1])+1;
            } else {
                dp[i] = dp[i-1]+1;
            }
        }
        System.out.println(dp[N]);
    }
}