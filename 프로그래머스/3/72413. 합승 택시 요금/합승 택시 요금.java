import java.util.*;

class Solution {
    
    static int INF = 100000 * 200;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], INF);
            cost[i][i] = 0;
        }
        
        for (int[] fare : fares) {
            cost[fare[0] - 1][fare[1] - 1] = fare[2];
            cost[fare[1] - 1][fare[0] - 1] = fare[2];
        }
        
        floydWarshall(cost, n);
        
        int answer = INF;
        for (int x = 0; x < n; x++) {
            int temp = cost[s - 1][x] + cost[x][a - 1] + cost[x][b - 1];
            answer = Math.min(answer, temp);
        }
        
        return answer;
    }
    
    public void floydWarshall(int[][] cost, int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (cost[i][j] > cost[i][k] + cost[k][j]) {
                        cost[i][j] = cost[i][k] + cost[k][j];
                    }
                }
            }
        }
    }
}
/*
1. 모든 정점 간의 최단 거리 구하기 => 플로이드-워셜

2. 한 정점에서 다른 모든 정점까지의 최단 거리 => 다익스트라


*/