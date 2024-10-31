import java.util.*;

class Solution {
    
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (char c : s.toCharArray()) {
            sb.append(c).append('#');
        }
        
        String str = sb.toString();
        int N = str.length();
        char[] chars = str.toCharArray();
        int[] P = new int[N];
        int C = 0;
        int R = 0;
        
        int answer = 1;
        for (int i = 0; i < N; i++) {
            if (i <= R) {
                P[i] = Math.min(P[2 * C - i], R - i);
            } 
            
            while (i - P[i] - 1 >= 0 && i + P[i] + 1 < N) {
                if (chars[i - P[i] - 1] != chars[i + P[i] + 1]) break;
                P[i]++;
            }
            
            if (R < i + P[i]) {
                C = i;
                R = i + P[i];
            }
            
            answer = Math.max(answer, P[i]);
        }
        
        return answer;
    }
}

/*
dp[i] => i번째 문자를 끝으로 하는 가장 긴 팰린드롬의 길이

dp[i - 1] => 홀수 팰린드롬일 때
1. 홀수 to 홀수
alpha[i - (dp[i - 1] + 1)] == alpha[i]
2. 홀수 to 짝수


dp[i - 1] => 짝수 팰린드롬일 때
*/