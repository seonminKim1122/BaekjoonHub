import java.util.*;

class Solution {
    
    static int INF = 100_001;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> graph = createGraph(n, roads);
        int[] dist = solve(n, graph, destination);
        
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            if (dist[sources[i]] == INF) {
                answer[i] = -1;
            } else {
                answer[i] = dist[sources[i]];
            }
        }
        
        return answer;
    }
    
    public int[] solve(int n, List<List<Integer>> graph, int destination) {
        
        int[] cost = new int[n + 1];
        Arrays.fill(cost, INF);
        cost[destination] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(destination);
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            for (int next : graph.get(now)) {
                if (cost[next] != INF) continue;
                cost[next] = cost[now] + 1;
                queue.add(next);
            }
        }
        
        return cost;
    }
    
    public List<List<Integer>> createGraph(int n, int[][] roads) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        return graph;
    }
}