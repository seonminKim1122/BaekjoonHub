import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] board;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (!isDisappeared()) {
            melt();
            time++;
        }

        System.out.println(time);
        System.out.println(result);
    }

    public static void melt() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll(); // 공기
            int i = now[0];
            int j = now[1];

            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];

                if (x < 0 || y < 0 || x >= N || y >= M || visited[x][y]) continue;

                if (board[x][y] == 0) {
                    queue.add(new int[]{x, y});
                } else {
                    board[x][y] = 0; // 1이면 치즈니까 녹이기
                    cnt++;
                }
                visited[x][y] = true;
            }
        }

        result = cnt;
    }

    public static boolean isDisappeared() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 0) return false;
            }
        }

        return true;
    }
}