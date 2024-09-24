import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        int i = score.length - 1;
        while (i >= m - 1) {
            int min = k + 1;
            for (int j = 0; j < m; j++) {
                if (min > score[i]) min = score[i];
                i--;
            }
            
            answer += min * m;
        }
        
        
        return answer;
    }
}