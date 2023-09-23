import java.util.Scanner;
/*
2 x n 직사각형 채우기
1. 2 x (n-1) 직사각형에 2 x 1 타일 추가
2. 2 x (n-2) 직사각형에 1 x 2 타일 2개 추가
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] dp = new long[1001];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}