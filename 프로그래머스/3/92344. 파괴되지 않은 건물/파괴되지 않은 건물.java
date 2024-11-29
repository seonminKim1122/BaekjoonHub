class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int R = board.length;
        int C = board[0].length;
        
        int[][] sum = new int[R][C];
        for (int[] now : skill) {
            int r1 = now[1], c1 = now[2], r2 = now[3], c2 = now[4];
            
            if (now[0] == 1) {
                sum[r1][c1] -= now[5];
                if (r2 + 1 < R) {
                    sum[r2 + 1][c1] += now[5];
                }
                if (c2 + 1 < C) {
                    sum[r1][c2 + 1] += now[5];
                }
                if (r2 + 1 < R && c2 + 1 < C) {
                    sum[r2 + 1][c2 + 1] -= now[5];
                }
            } else {
                sum[r1][c1] += now[5];
                if (r2 + 1 < R) {
                    sum[r2 + 1][c1] -= now[5];
                }
                if (c2 + 1 < C) {
                    sum[r1][c2 + 1] -= now[5];
                }
                if (r2 + 1 < R && c2 + 1 < C) {
                    sum[r2 + 1][c2 + 1] += now[5];
                }
            }
        }
        
        for (int r = 1; r < R; r++) {
            sum[r][0] += sum[r - 1][0];
        }
        for (int c = 1; c < C; c++) {
            sum[0][c] += sum[0][c - 1];
        }
        
        for (int r = 1; r < R; r++) {
            for (int c = 1; c < C; c++) {
                sum[r][c] += sum[r - 1][c] + sum[r][c - 1] - sum[r - 1][c - 1];
            }
        }
        
        
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] + sum[r][c] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}

/*
a ~ b 에 degree 만큼 공격

[0, 0, 0, 0, 0]
1 ~ 3 에 3 공격 : [0, -3, 0, 0, 3]
2 ~ 3 에 2 공격 : [0, -3, -2, 0, 5]
0 ~ 2 에 1 공격 : [-1, -3, -2, 1, 5]
누적합 : [-1, -4, -6, -5, 0]

a ~ b 에 degree 만큼 공격
=> a에 -degree, b+1 에 +degree
a ~ b 에 degree 만큼 회복
=> a에 +degree, b+1 에 -degree

만들어진 결과 배열을 누적합 하면 각 point 별로 받은 데미지+회복 계산이 완료됨


*/