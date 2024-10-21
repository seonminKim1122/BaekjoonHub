import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = solve(n, edge);
        return answer;
    }
    
    public int solve(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];
        queue.add(new int[]{1, 0});
        visit[1] = true;
        
        int max = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            if (now[1] == max) {
                result++;
            } else {
                max = now[1];
                result = 1;
            }
            
            for (int next : graph.get(now[0])) {
                if (visit[next]) continue;
                queue.add(new int[]{next, now[1] + 1});
                visit[next] = true;
            }
        }
        
        return result;
    }
}