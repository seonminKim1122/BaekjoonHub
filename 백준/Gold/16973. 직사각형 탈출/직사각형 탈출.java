import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] grid;
    static int H;
    static int W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        int Sr = Integer.parseInt(st.nextToken()) - 1;
        int Sc = Integer.parseInt(st.nextToken()) - 1;
        int Fr = Integer.parseInt(st.nextToken()) - 1;
        int Fc = Integer.parseInt(st.nextToken()) - 1;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new int[]{Sr, Sc, 0});
        visited[Sr][Sc] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == Fr && now[1] == Fc) {
                System.out.println(now[2]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x < 0 || y < 0 || x + H > N || y + W > M || visited[x][y]) continue;

                if (canMove(x, y)) {
                    queue.add(new int[]{x, y, now[2] + 1});
                    visited[x][y] = true;
                }
            }
        }
        System.out.println(-1);
    }

    public static boolean canMove(int i, int j) {
        // 직사각형 왼쪽 위가 i, j 라고 했을 때 벽에 안 걸리는지
        for (int k = 0; k < H; k++) {
            if (grid[i + k][j] == 1 || grid[i + k][j + W - 1] == 1) return false;
        }

        for (int k = 0; k < W; k++) {
            if (grid[i][j + k] == 1 || grid[i + H - 1][j + k] == 1) return false;
        }

        return true;
    }
}