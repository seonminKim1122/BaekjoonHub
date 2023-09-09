import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] horseX = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] horseY = {1, -1, 2, -2, 2, -2, 1, -1};

    static int[] monkeyX = {-1, 1, 0, 0};
    static int[] monkeyY = {0, 0, -1, 1};

    static int[][] grid;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine()); // horse move 할 수 있는 횟수

        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        grid = new int[H][W];
        visited = new boolean[K+1][H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == H - 1 && now[1] == W - 1) {
                System.out.println(now[3]);
                return;
            }

            if (now[2] < K) {
                for (int i = 0; i < 8; i++) {
                    int x = now[0] + horseX[i];
                    int y = now[1] + horseY[i];

                    if (x < 0 || y < 0 || x >= H || y >= W || visited[now[2] + 1][x][y] || grid[x][y] == 1) continue;

                    queue.add(new int[]{x, y, now[2] + 1, now[3] + 1});
                    visited[now[2] + 1][x][y] = true;
                }
            } 
            
            for (int i = 0; i < 4; i++) {
                int x = now[0] + monkeyX[i];
                int y = now[1] + monkeyY[i];

                if (x < 0 || y < 0 || x >= H || y >= W || visited[now[2]][x][y] || grid[x][y] == 1) continue;

                queue.add(new int[]{x, y, now[2], now[3] + 1});
                visited[now[2]][x][y] = true;
            }
        }

        System.out.println(-1);
    }
}