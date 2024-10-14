import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int N = sticker.length;
        if (N == 1) return sticker[0];
        
        // 0번째 스티커를 뜯은 케이스
        int[] dp1 = new int[N];
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        for (int i = 2; i < N - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }
        dp1[N - 1] = dp1[N - 2];
        
        // 그렇지 않은 케이스 분리 필요
        int[] dp2 = new int[N];
        dp2[1] = sticker[1];
        for (int i = 2; i < N; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }
        
        int answer = Math.max(dp1[N - 1], dp2[N - 1]);
        return answer;
    }
}
/*
N 은 최대 100,000
뜯는 횟수 최대 50,000 => 백트래킹으로 풀면 시간초과

Dynamic Programming?
이거 마치 전구?

dp[i] => 0번째 부터 i번째 까지 고려했을 때 최대 점수
dp[i - 1] vs dp[i - 2] + i
*/