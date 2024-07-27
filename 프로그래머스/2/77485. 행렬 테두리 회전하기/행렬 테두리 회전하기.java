class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] matrix = new int[rows][columns];
        init(matrix, rows, columns);
        
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            answer[i] = solve(matrix, query);
        }
        
        return answer;
    }
    
    void init(int[][] matrix, int rows, int columns) {
        int v = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = v++;
            }
        }
    } 
    
    int solve(int[][] matrix, int[] query) {
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;
        
        int first = matrix[x1][y1];
        int result = first;
        
        for (int i = x1; i < x2; i++) {
            matrix[i][y1] = matrix[i + 1][y1];
            result = Math.min(result, matrix[i][y1]);
        }
        
        for (int j = y1; j < y2; j++) {
            matrix[x2][j] = matrix[x2][j + 1];
            result = Math.min(result, matrix[x2][j]);
        }
        
        for (int i = x2; i > x1; i--) {
            matrix[i][y2] = matrix[i - 1][y2];
            result = Math.min(result, matrix[i][y2]);
        }
        
        for (int j = y2; j > y1; j--) {
            matrix[x1][j] = matrix[x1][j - 1];
            result = Math.min(result, matrix[x1][j]);
        }
        
        matrix[x1][y1 + 1] = first;
        
        return result;
    }
}

/*
(x1, y1) ~ (x1, y2)
(x1, y2) ~ (x2, y2)
(x2, y2) ~ (x2, y1)
(x2, y1) ~ (x1, y1)
*/