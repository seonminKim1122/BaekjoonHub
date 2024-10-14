class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int H = triangle.length;
        int W = triangle[H - 1].length;
        
        int[][] dp = new int[H][W];
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < H; i++) {
            int w = triangle[i].length;
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            dp[i][w - 1] = dp[i - 1][w - 2] + triangle[i][w - 1];
            for (int j = 1; j < w - 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }
        
        for (int j = 0; j < W; j++) {
            answer = Math.max(answer, dp[H - 1][j]);
        }
        
        return answer;
    }
}
/*

dp[i][j] = (dp[i - 1][j - 1] vs dp[i - 1][j])

*/