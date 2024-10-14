class Solution {
    
    static int MOD = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        boolean[][] isPuddle = new boolean[n][m];
        int[][] dp = new int[n][m];
        init(dp, isPuddle, puddles, n, m);
        
        solve(dp, isPuddle, n, m);
        
        answer = dp[n - 1][m - 1];
        return answer;
    }
    
    void init(int[][] dp, boolean[][] isPuddle, int[][] puddles, int n, int m) {
        for (int[] puddle : puddles) {
            isPuddle[puddle[1] - 1][puddle[0] - 1] = true;
        }
        
        for (int i = 0; i < n; i++) {
            if (isPuddle[i][0]) break;
            dp[i][0] = 1;
        }
        
        for (int j = 0; j < m; j++) {
            if (isPuddle[0][j]) break;
            dp[0][j] = 1;
        }
    }
    
    void solve(int[][] dp, boolean[][] isPuddle, int n, int m) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (isPuddle[i][j]) continue;
                dp[i][j] = (dp[i - 1][j] % MOD + dp[i][j - 1] % MOD) % MOD;
            }
        }
    }
}