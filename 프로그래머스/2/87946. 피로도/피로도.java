class Solution {
    
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        // k : 현재 피로도
        
        answer = -1;
        
        int N = dungeons.length;
        boolean[] visit = new boolean[N];
        
        solve(dungeons, k, 0, N, visit);
        
        return answer;
    }
    
    void solve(int[][] dungeons, int now, int depth, int N, boolean[] visit) {
        answer = Math.max(answer, depth);
        if (depth == N) {
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (visit[i]) continue;
            if (now < dungeons[i][0]) continue;
            
            visit[i] = true;
            solve(dungeons, now - dungeons[i][1], depth + 1, N, visit);
            visit[i] = false;
        }
    }
}