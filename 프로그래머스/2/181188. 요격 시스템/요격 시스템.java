import java.util.*;              

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        
        answer++;
        int[] criteria = targets[0];
        int N = targets.length;
        
        for (int i = 1; i < N; i++) {
            int[] target = targets[i];
            
            if (criteria[1] > target[0]) continue;
            answer++;
            criteria = target;
        }
        
        return answer;
    }
}
/*
[1 4] -> 1 < missile < 4 
[3 7] -> 3 < missile < 7
[4 5]
[4 8]
[5 12]
[10 14]
[11 13]

*/