import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        int N = priorities.length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.add(new int[]{i, priorities[i]});
        }
        
        Arrays.sort(priorities);
        
        int idx = N - 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            int process = now[0];
            int priority = now[1];
            
            if (priority < priorities[idx]) {
                // 현재 작업보다 우선순위가 높은 작업이 남았다
                queue.add(now);
            } else {
                // 현재 작업보다 우선순위가 높은 작업이 없다.
                idx--;
                if (process == location) {
                    answer = (N - 1) - idx;
                    break;
                }
            }
        }
        
        return answer;
    }
}
