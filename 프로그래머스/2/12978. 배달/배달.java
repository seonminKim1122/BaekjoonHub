import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        // 초기화
        int INF = 2000 * 10000;
        int[] dist = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dist[i] = INF;
        }
        dist[1] = 0;
        int[][] graph = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                graph[i][j] = INF;
            }
        }
 
        for (int i = 0; i < road.length; i++) {
            int v1 = road[i][0];
            int v2 = road[i][1];
            int d = Math.min(graph[v1][v2], road[i][2]);
    
            graph[v1][v2] = graph[v2][v1] = d;
        }
        
        // 다익스트라
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{1, 0});
        
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            
            int from = edge[0];
            
            for (int to = 1; to <= N; to++) {
                if (graph[from][to] == INF) continue;
                if (dist[to] > dist[from] + graph[from][to]) {
                    dist[to] = dist[from] + graph[from][to];
                    pq.add(new int[]{to, dist[to]});
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }
        
        return answer;
    }
}