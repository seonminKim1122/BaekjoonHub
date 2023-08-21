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
        int H = Integer.parseInt(st.nextToken());

        int[][][] tomatoes = new int[H][N][M];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    tomatoes[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomatoes[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k, 0});
                    }
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[] dh = {1, -1};

        int result = 0;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for (int i = 0; i < 2; i++) {
                int h = temp[0] + dh[i];

                if (h < 0 || h >= H || tomatoes[h][temp[1]][temp[2]] != 0) continue;

                queue.add(new int[]{h, temp[1], temp[2], temp[3]+1});
                tomatoes[h][temp[1]][temp[2]] = 1;
            }

            for (int i = 0; i < 4; i++) {
                int x = temp[1] + dx[i];
                int y = temp[2] + dy[i];

                if (x < 0 || y < 0 || x >= N || y >= M || tomatoes[temp[0]][x][y] != 0) continue;

                queue.add(new int[]{temp[0], x, y, temp[3]+1});
                tomatoes[temp[0]][x][y] = 1;
            }

            if (queue.isEmpty()) {
                result = temp[3];
                break;
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomatoes[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(result);
    }
}