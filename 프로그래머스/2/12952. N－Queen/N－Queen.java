class Solution {
    public int solution(int n) {
                
        boolean[][] isQueen = new boolean[n][n];
        return solve(isQueen, 0, n);
    }
    
    int solve(boolean[][] isQueen, int col, int n) {
        if (col == n) {
            return 1;
        }
        
        int result = 0;
        for (int row = 0; row < n; row++) {
            if (!isRowValid(isQueen, row, col)) continue;
            if (!isDiagonalValid(isQueen, row, col)) continue;
            
            isQueen[row][col] = true;
            result += solve(isQueen, col + 1, n);
            isQueen[row][col] = false;
        }
        return result;
    }
    
    boolean isRowValid(boolean[][] isQueen, int row, int col) {
        for (int y = 0; y < col; y++) {
            if (isQueen[row][y]) return false;
        }
        return true;
    }
    
    boolean isDiagonalValid(boolean[][] isQueen, int row, int col) {
        int[] dx = {-1, 1};
        int[] dy = {-1, -1};
        
        int n = isQueen.length;
        for (int k = 0; k < 2; k++) {
            int nx = row + dx[k];
            int ny = col + dy[k];
            
            while (!(nx < 0 || ny < 0 || nx >= n || ny >= n)) {
                if (isQueen[nx][ny]) return false;
                nx += dx[k];
                ny += dy[k];
            }
        }
        
        return true;
    }
    
}