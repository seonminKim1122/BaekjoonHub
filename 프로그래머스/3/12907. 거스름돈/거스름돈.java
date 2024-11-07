import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        Arrays.sort(money);
        
        int N = money.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int j = 1; j <= n; j++) {
            if (j % money[0] == 0) dp[j] = 1;
        }
        
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= n; j++) {
                if (j - money[i] >= 0) {
                    dp[j] += dp[j - money[i]];
                    dp[j] %= 1_000_000_007;
                }
            }
        }
        
        int answer = dp[n] % 1_000_000_007;
        return answer;
    }
}
/*
dp [1 1 2 2 1 1]

1. j 가 money[0] 의 배수이면 dp[0][j] 를 1로 채우기
2. dp[i][j] = dp[i - 1][j] + (dp[i - 1][j - money[i]]) while (j - money[i] >= 0)
*/