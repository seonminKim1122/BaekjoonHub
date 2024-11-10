class Solution {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n + 1][n + 1];
        for (int[] result: results) {
            graph[result[0]][result[1]] = 1;
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (canRank(i, graph, n)) answer++;
        }
        return answer;
    }
    
    public boolean canRank(int player, int[][] graph, int n) {
        int temp1 = higher(player, graph, new boolean[n + 1], n);
        int temp2 = lower(player, graph, new boolean[n + 1], n);
        return temp1 + temp2 == n - 1;
    }
    
    public int higher(int player, int[][] graph, boolean[] visit, int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (visit[i] || graph[i][player] == 0) continue;
            visit[i] = true;
            result++;
            result += higher(i, graph, visit, n);
        }
        return result;
    }
    
    public int lower(int player, int[][] graph, boolean[] visit, int n) {
        int result = 0;
        for (int j = 1; j <= n; j++) {
            if (visit[j] || graph[player][j] == 0) continue;
            visit[j] = true;
            result++;
            result += lower(j, graph, visit, n);
        }
        return result;
    }
}
/*
1, 2, 3, 4, 5

4 -> 3
4 -> 2
3 -> 2
1 -> 2
2 -> 5

1 보다 높은 사람: 0
1 보다 낮은 사람: 2

2보다 높은 사람: 3
2보다 낮은 사람: 1

3보다 높은 사람: 1
3보다 낮은 사람: 2

4보다 높은 사람: 0
4보다 낮은 사람: 3
*/