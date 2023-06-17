import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[][] distances = new int[n][m];
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(temp.nextToken());

                if (map[i][j] == 2) {
                    queue.add(new Point(i, j));
                    distances[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }

        int[] dx = {0 , 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        // bfs 로 거리 계산
        while (!queue.isEmpty()) {
            Point point = queue.remove();
            
            for (int k = 0; k < 4; k++) {
                int x = point.x + dx[k];
                int y = point.y + dy[k];

                if (x < 0 || y < 0 || x >= n || y >= m || map[x][y] != 1 || visited[x][y]) continue;
                distances[x][y] = distances[point.x][point.y] + 1;
                queue.add(new Point(x, y));
                visited[x][y] = true;
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    sb.append(-1).append(" ");
                } else {
                    sb.append(distances[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}