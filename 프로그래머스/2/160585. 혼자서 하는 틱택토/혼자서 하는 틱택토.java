class Solution {
    public int solution(String[] input) {
        int answer = 0;
        
        char[][] temp = new char[3][3];
        char[][] board = new char[3][3];
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = input[i].charAt(j);
                temp[i][j] = '.';
            }
        }
        
        if (solve(0, temp, board, new char[]{'O', 'X'})) {
            answer = 1;
        }
        
        return answer;
    }
    
    boolean solve(int depth, char[][] temp, char[][] board, char[] ox) {
        if (isSame(temp, board)) return true;
        if (isGameOver(temp)) return false;
        
        boolean result = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (temp[i][j] != '.') continue;
                
                temp[i][j] = ox[depth % 2];
                result = result || solve(depth + 1, temp, board, ox);
                temp[i][j] = '.';
                
                if (result) return result;
            }
        }
        
        return result;
    }
    
    boolean isGameOver(char[][] board) {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == '.') continue;
            if (board[row][0] == board[row][1] && board[row][1] == board[row][2]) return true;
        }
        
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == '.') continue;
            if (board[0][col] == board[1][col] && board[1][col] == board[2][col]) return true;
        }
        
        if (board[1][1] != '.') {
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true;
            if (board[2][0] == board[1][1] && board[1][1] == board[0][2]) return true;
        }
        
        return false;
    }
    
    boolean isSame(char[][] arr1, char[][] arr2) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr1[i][j] != arr2[i][j]) return false;
            }
        }
        return true;
    }
}

/*
규칙을 잘 지켰다
1. 승리자가 나온 경우
=> O 가 승리 : O == X + 1
=> X 가 승리 : O == X

2. 승리자가 나오지 않은 경우
=> O == X || O == X + 1 이기만 하면 성립
*/