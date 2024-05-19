import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        int N = maps.length;
        int M = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        int[][] counts = new int[N][M];
        
        queue.add(new int[]{0, 0, 1});
        counts[0][0] = 1;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for (int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (maps[nx][ny] == 0 || counts[nx][ny] != 0) continue;
                
                queue.add(new int[]{nx, ny, now[2] + 1});
                counts[nx][ny] = now[2] + 1;
            }
        }
        
        answer = counts[N - 1][M - 1] == 0 ? -1 : counts[N - 1][M - 1];
        return answer;
    }
}
