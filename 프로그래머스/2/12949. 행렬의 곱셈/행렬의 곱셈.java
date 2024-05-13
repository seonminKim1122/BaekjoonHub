class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int R = arr1.length;
        int C = arr2[0].length;
        int M = arr2.length;
        
        int[][] answer = new int[R][C];
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int m = 0; m < M; m++) {
                    answer[i][j] += (arr1[i][m] * arr2[m][j]);
                }
            }
        }
        
        return answer;
    }
}