import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = solve(board);
        return answer;
    }
    
    public int solve(int[][] board) {
        int N = board.length;
        
        int[][][] visitCost = new int[N][N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visitCost[i][j][0] = Integer.MAX_VALUE;
                visitCost[i][j][1] = Integer.MAX_VALUE;
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        visitCost[0][0][0] = 0;
        visitCost[0][0][1] = 0;
        queue.add(new int[]{0, 0, 0});
        queue.add(new int[]{0, 0, 1});
   
        int[] dx = {0, 0, -1, 1}; // 세로
        int[] dy = {-1, 1, 0, 0}; // 가로
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            int x = now[0];
            int y = now[1];
            int d = now[2];
            
            for (int k = d * 2; k < (d + 1) * 2; k++) { // 원래 방향 유지
                int nx = x + dx[k];
                int ny = y + dy[k];
                
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (board[nx][ny] == 1 || visitCost[nx][ny][d] <= visitCost[x][y][d] + 100) continue;
                
                queue.add(new int[]{nx, ny, d});
                visitCost[nx][ny][d] = visitCost[x][y][d] + 100;
            }
            
            int nd = (d + 1) % 2; // 방항 변경
            for (int k = nd * 2; k < (nd + 1) * 2; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (board[nx][ny] == 1 || visitCost[nx][ny][nd] < visitCost[x][y][d] + 600) continue;
                
                queue.add(new int[]{nx, ny, nd});
                visitCost[nx][ny][nd] = visitCost[x][y][d] + 600;
            }
        }
        
        return Math.min(visitCost[N - 1][N - 1][0], visitCost[N - 1][N - 1][1]);
    }
}
/*
가로 방향
세로 방향

직선 도로 만들 때 하나에 100원
방향 전환하려면 코너를 만들어야 하며 이때 500원이 추가 비용

같은 위치더라도 어떤 방향으로 왔느냐에 따라 다음 칸으로 이동하기 위한 비용이 달라질 수 있음
*/