import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int wanho1 = scores[0][0];
        int wanho2 = scores[0][1];
        
        int[] wanho = new int[]{wanho1, wanho2};
        
        Arrays.sort(scores, (s1, s2) -> s1[0] - s2[0] == 0 ? s1[1] - s2[1] : s2[0] - s1[0]);
        
        // 인센티브 못 받는 사람들
        Set<Integer> out = new HashSet<>();
        int N = scores.length;
        int criteria = scores[0][1];
        for (int i = 0; i < N; i++) {
            if (scores[i][1] < criteria) {
                if (scores[i][0] == wanho[0] && scores[i][1] == wanho[1]) return -1;
                
                out.add(i);
            } else {
                criteria = scores[i][1];
            }
        }
        
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (out.contains(i)) continue;
            if (scores[i][0] + scores[i][1] > wanho[0] + wanho[1]) answer++;
        }
        
        return answer + 1;
    }
}