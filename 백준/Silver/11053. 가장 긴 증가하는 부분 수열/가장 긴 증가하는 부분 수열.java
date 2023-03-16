import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        // dp[N] : N번째 숫자를 포함한 가장 긴 부분 수열의 길이
        // dp[N]을 구하는 방법
        // 정답 : dp[1] ~ dp[N] 중 Max값
        // 4 5 1 6 2 1 3 4 5 6 7
        // 10 20 10 30 20 50
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N+1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = 1;
            for (int j = i-1; j >= 1; j--) {
                if (numbers[j] < numbers[i]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (result < dp[i]) result = dp[i];
        }
        System.out.println(result);
    }
}