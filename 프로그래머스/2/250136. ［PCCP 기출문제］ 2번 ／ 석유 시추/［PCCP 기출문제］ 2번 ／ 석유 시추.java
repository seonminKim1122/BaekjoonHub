import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        
        int H = land.length;
        int W = land[0].length;
        
        boolean[][] visit = new boolean[H][W];
        int[] results = new int[W];
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (!visit[i][j] && land[i][j] == 1) {
                    boolean[] path = new boolean[W];
                    int size = solve(land, visit, path, i, j, H, W);
                    for (int k = 0; k < W; k++) {
                        if (path[k]) results[k] += size;
                    }
                }
            }
        }
        
        
        
        for (int i = 0; i < W; i++) {
            answer = Math.max(results[i], answer);
        }
        
        return answer;
    }
    
    int solve(int[][] land, boolean[][] visit, boolean[] path, int x, int y, int H, int W) {
        Queue<int[]> queue = new LinkedList<>();
        visit[x][y] = true;
        queue.add(new int[]{x, y, 1});
        path[y] = true;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int result = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for (int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                
                if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if (visit[nx][ny] || land[nx][ny] == 0) continue;
                
                queue.add(new int[]{nx, ny});
                visit[nx][ny] = true;
                path[ny] = true;
                result++;
            }
        }
        
        return result;
    }
}

/*
1번 dfs 돌면 해당 석유 덩어리가 지나가는 컬럼을 알아낼 수 있다.
알아낸 컬럼들에 얻을 수 있는 석유 덩어리 값을 + 해주자.
*/