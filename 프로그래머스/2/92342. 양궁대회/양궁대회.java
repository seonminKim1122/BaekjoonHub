import java.util.*;

class Solution {
    public int[] solution(int n, int[] info) {
        int[][] dp = new int[11][n + 1];
        
        init(dp, info, n);
        calc(dp, info, n);
        
        if (dp[10][0] <= 0) {
            return new int[]{-1};
        }
        
        int[] answer = new int[11];
        trace(dp, info, n, answer);

        return answer;
    }
    
    void init(int[][] dp, int[] info, int n) {
        int apeach = 0;
        for (int i = 0; i < 11; i++) {
            if (info[i] > 0) apeach += (10 - i);
        }
        
        for (int j = 0; j <= n; j++) {
            dp[0][j] = -apeach;
        }
        
        for (int j = 0; j <= n - (info[0] + 1); j++) {
            if (info[0] > 0) {
                dp[0][j] = -apeach + 20;
            } else {
                dp[0][j] = -apeach + 10;
            }
        }
    }
    
    void calc(int[][] dp, int[] info, int n) {
        for (int i = 1; i < 11; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j + info[i] + 1 <= n) {
                    if (info[i] == 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + info[i] + 1] + (10 - i));
                    } else {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + info[i] + 1] + 2 * (10 - i));
                    }
                }
            }
        }
    }
    
    void trace(int[][] dp, int[] info, int n, int[] answer) {
        int remain = 0;
        for (int j = 0; j <= n; j++) {
            if (dp[10][j] >= dp[10][0]) remain = j;
        }
        
        answer[10] = remain;
        for (int i = 9; i > 0; i--) {
            if (remain + info[i] + 1 > n) continue;
            
            if (info[i] == 0) {
                if (dp[i][remain] == dp[i - 1][remain + info[i] + 1] + (10 - i)) {
                    answer[i] = info[i] + 1;
                    remain += (info[i] + 1);
                }
            } else {
                if (dp[i][remain] == dp[i - 1][remain + info[i] + 1] + 2 * (10 - i)) {
                    answer[i] = info[i] + 1;
                    remain += (info[i] + 1);
                }
            } 
        }
        answer[0] = n - remain;
    }
}

/*


x 번째 과녁에서 화살이 y 발 남을 때 얻을 수 있는 최대 점수
점수차를 기록해야겟당
dp[x - 1][y + info[x] + 1] + (10 - x) 
vs
dp[x - 1][y]

그럼 결국 마지막 과녁까지 왔을 때... 역으로 트래킹이 가능해야 한다.

dp[10][0] 이 가장 차이를 많이 낼 때의 점수차이긴한데
이를 역으로 트래킹할 방법이 필요하다.

*/