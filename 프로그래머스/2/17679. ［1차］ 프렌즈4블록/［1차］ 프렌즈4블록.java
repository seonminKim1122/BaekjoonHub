import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] friendsBoard = new char[m][n];
        init(friendsBoard, board);
        
        while (true) {
            int squareBlocks = 0;
            Queue<int[]> points = new LinkedList<>();
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (friendsBoard[i][j] != '.' && isSquareBlock(i, j, friendsBoard)) {
                        squareBlocks++;
                        points.add(new int[]{i, j});
                    }
                }
            }
            
            if (squareBlocks <= 0) break;
            
            while (!points.isEmpty()) {
                int[] point = points.poll();
                answer += explode(point[0], point[1], friendsBoard);
            }
            
            // 빈칸 채우기
            for (int j = 0; j < n; j++) {
                moveDown(j, friendsBoard);
            }
        }
        
        
        return answer;
    }
    
    public void init(char[][] friendsBoard, String[] inputBoard) {
        for (int i = 0; i < friendsBoard.length; i++) {
            for (int j = 0; j < friendsBoard[i].length; j++) {
                friendsBoard[i][j] = inputBoard[i].charAt(j);
            }
        }
    }
    
    public boolean isSquareBlock(int i, int j, char[][] friendsBoard) {
        if (i + 1 >= friendsBoard.length || j + 1 >= friendsBoard[i].length) return false;
        
        char c1 = friendsBoard[i][j];
        char c2 = friendsBoard[i + 1][j];
        char c3 = friendsBoard[i][j + 1];
        char c4 = friendsBoard[i + 1][j + 1];
        
        return c1 == c2 && c2 == c3 && c3 == c4;
    }
    
    public int explode(int i, int j, char[][] board) {
        int result = 0;
        if (board[i][j] != '.') result++;
        if (board[i + 1][j] != '.') result++;
        if (board[i][j + 1] != '.') result++;
        if (board[i + 1][j + 1] != '.') result++;
        
        board[i][j] = board[i + 1][j] = board[i][j + 1] = board[i + 1][j + 1] = '.';    
        return result;
    }
    
    public void moveDown(int j, char[][] friendsBoard) {
        for (int i = friendsBoard.length - 1; i >= 0; i--) {
            if (friendsBoard[i][j] != '.') continue;
            
            int h = i - 1;
            while (h >= 0 && friendsBoard[h][j] == '.') {
                h--;
            }
            
            if (h < 0) return;
            
            friendsBoard[i][j] = friendsBoard[h][j];
            friendsBoard[h][j] = '.';
        }
    } 
}