import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visit = new boolean[y + 1];
        queue.add(new int[]{x, 0});
        visit[x] = true;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            if (now[0] == y) {
                answer = now[1];
                break;
            }
            
            int num1 = now[0] + n;
            int num2 = now[0] * 2;
            int num3 = now[0] * 3;
            
            if (num1 <= y && !visit[num1]) {
                queue.add(new int[]{num1, now[1] + 1});
                visit[num1] = true;
            }
            
            if (num2 <= y && !visit[num2]) {
                queue.add(new int[]{num2, now[1] + 1});
                visit[num2] = true;
            }
            
            if (num3 <= y && !visit[num3]) {
                queue.add(new int[]{num3, now[1] + 1});
                visit[num3] = true;
            }
        }
        
        return answer;
    }
}