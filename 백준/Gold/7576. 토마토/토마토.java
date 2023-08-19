import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] box = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int result = 0;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = temp[0] + dx[i];
                int y = temp[1] + dy[i];

                if (x < 0 || y < 0 || x >= N || y >= M || visited[x][y] || box[x][y] != 0) continue;

                queue.add(new int[]{x, y, temp[2]+1});
                visited[x][y] = true;
                result = temp[2] + 1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] != -1 && !visited[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(result);
    }
}