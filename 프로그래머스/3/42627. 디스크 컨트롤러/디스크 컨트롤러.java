import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0] == 0 ? j1[1] - j2[1] : j1[0] - j2[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((j1, j2) -> j1[1] - j2[1]);
        
        int idx = 0;
        int done = 0;
        int total = jobs.length;
        int before = 0;
        int answer = 0;
        while (done < total) {
            while (idx < total && jobs[idx][0] < before) {
                pq.add(jobs[idx++]);
            }
            
            if (pq.isEmpty()) { // 그냥 지금 작업을 하면 된다
                answer += jobs[idx][1];
                before = (jobs[idx][0] + jobs[idx][1]);
                idx++;
            } else {
                int[] job = pq.poll();
                answer += (before + job[1] - job[0]);
                before += job[1];
            }
            done++;
        }
        
        answer /= total;
        return answer;
    }
}
/*
하드디스크가 놀고 있다의 개념이 조금 모호함.

0 3
1 9
6 6

0 3, 1 9, 6 6 => 
*/