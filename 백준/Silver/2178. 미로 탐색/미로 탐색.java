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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] miro = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int[][] distances = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                miro[i][j] = Integer.parseInt(temp[j]);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        distances[0][0] = 1;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        int result = 0;
        while (!queue.isEmpty()) {
            int[] temp = queue.remove();
            for (int i = 0; i < 4; i++) {
                int x = temp[0] + dx[i];
                int y = temp[1] + dy[i];

                if (x < 0 || y < 0 || x >= N || y >= M || visited[x][y] || miro[x][y] == 0) continue;

                queue.add(new int[]{x, y});
                visited[x][y] = true;
                distances[x][y] = distances[temp[0]][temp[1]] + 1;
            }
        }

        System.out.println(distances[N-1][M-1]);
    }
}