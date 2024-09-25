class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        int H = park.length;
        int W = park[0].length;
        
        int[][] dp = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (park[i][j].equals("-1")) {
                    dp[i][j] = 1;
                }
            }
        }
        
        int availableSize = 0;
        for (int i = 1; i < H; i++) {
            for (int j = 1; j < W; j++) {
                if (park[i][j].equals("-1")) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                availableSize = Math.max(availableSize, dp[i][j]);
            }
        }
        
        for (int mat : mats) {
            if (mat > availableSize) continue;
            answer = Math.max(answer, mat);
        }
        
        return answer;
    }
}

/*
["A", "A", "-1", "B", "B", "B", "B", "-1"], 
["A", "A", "-1", "B", "B", "B", "B", "-1"], 
["-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"], 
["D", "D", "-1", "-1", "-1", "-1", "E", "-1"], 
["D", "D", "-1", "-1", "-1", "-1", "-1", "F"], 
["D", "D", "-1", "-1", "-1", "-1", "E", "-1"]]
*/