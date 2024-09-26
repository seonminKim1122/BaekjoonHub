import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int temp1 = solve(maps, 'S', 'L');
        int temp2 = solve(maps, 'L', 'E');
        
        if (temp1 == -1 || temp2 == -1) return -1;
        
        return temp1 + temp2;
    }
    
    int solve(String[] maps, char start, char end) {
        int H = maps.length;
        int W = maps[0].length();
        
        Queue<int[]> queue = new LinkedList<>();
        int[][] visitCost = new int[H][W];
        int over = H * W + 1;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (maps[i].charAt(j) == start) {
                    queue.add(new int[]{i, j});
                    visitCost[i][j] = 0;
                } else {
                    visitCost[i][j] = over;
                }
            }
        }
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            int x = now[0];
            int y = now[1];
            
            if (maps[x].charAt(y) == end) {
                return visitCost[x][y];
            }
            
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                
                if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if (maps[nx].charAt(ny) == 'X') continue;
                if (visitCost[nx][ny] <= visitCost[x][y] + 1) continue;
                
                queue.add(new int[]{nx, ny});
                visitCost[nx][ny] = visitCost[x][y] + 1;
            }
        }
        return -1;
    }
    
    // 1. S -> L 시간 구하기
    // 2. L -> S 시간 구하기
    // 3. 둘이 더하기
    // 4. 1번, 2번 중 하나라도 이동이 불가능하면 -1
}