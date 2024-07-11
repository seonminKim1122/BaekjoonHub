class Solution {
    public int solution(int n, int[][] wires) {
        boolean[][] isConnect = new boolean[n + 1][n + 1];
        for (int[] wire : wires) {
            isConnect[wire[0]][wire[1]] = true;
            isConnect[wire[1]][wire[0]] = true;
        }
        
        int answer = n;
        for(int[] wire : wires) {
            isConnect[wire[0]][wire[1]] = false;
            isConnect[wire[1]][wire[0]] = false;
            
            int group1 = solve(isConnect, wire[0], new boolean[n + 1]);
            int group2 = solve(isConnect, wire[1], new boolean[n + 1]);
            
            answer = Math.min(answer, Math.abs(group1 - group2));
            
            isConnect[wire[0]][wire[1]] = true;
            isConnect[wire[1]][wire[0]] = true;
        }
        
        return answer;
    }
    
    int solve(boolean[][] isConnect, int now, boolean[] visit) {
        visit[now] = true;
        
        int result = 1;
        for (int next = 1; next < isConnect[now].length; next++) {
            if (visit[next]) continue;
            if (!isConnect[now][next]) continue;
            result += solve(isConnect, next, visit);
        }
        
        return result;
    }
}