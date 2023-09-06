import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] icebergs;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        icebergs = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                icebergs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (true) {
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (icebergs[i][j] == 0 && isNearByIceberg(i, j)) {
                        queue.add(new int[]{i, j}); // 근처에 빙하가 있는 0 만 queue 에 추가하면 되는데...
                    }
                }
            }

            melt(queue);
            time++;

            int cnt = numOfIcebergs();

            if (cnt >= 2) {
                break;
            }

            if (cnt == 0) {
                time = 0;
                break;
            }
        }

        System.out.println(time);
    }

    public static void melt(Queue<int[]> queue) {

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x < 0 || y < 0 || x >= N || y >= M) continue;

                if (icebergs[x][y] > 0) {
                    icebergs[x][y] = icebergs[x][y] - 1;
                }
            }
        }
    }

    public static int numOfIcebergs() {
        boolean[][] visited = new boolean[N][M];

        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (icebergs[i][j] != 0 && !visited[i][j]) {
                    dfs(visited, i, j);
                    result++;
                    if (result >= 2) return result;
                }
            }
        }

        return result;
    }

    public static void dfs(boolean[][] visited, int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || icebergs[nx][ny] == 0) continue;

            dfs(visited, nx, ny);
        }
    }

    public static boolean isNearByIceberg(int i, int j) {
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || y < 0 || x >= N || y >= M) continue;
            if (icebergs[x][y] != 0) return true;
        }

        return false;
    }
}