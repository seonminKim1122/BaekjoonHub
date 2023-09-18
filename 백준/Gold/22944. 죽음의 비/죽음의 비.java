import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int H;
    static int D;
    static char[][] grid;
    static int[][] visited;

    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        grid = new char[N][N];
        visited = new int[N][N];

        int[] start = new int[2];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = input.charAt(j);

                if (grid[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        bfs(start);

        System.out.println(result);
    }

    public static void bfs(int[] start) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0, 0, H});
        visited[start[0]][start[1]] = H;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x < 0 || y < 0 || x >= N || y >= N) continue;

                if (grid[x][y] == 'E') {
                    result = now[2] + 1;
                    return;
                }

                int umbrella = now[3];
                int hp = now[4];

                if (grid[x][y] == 'U') {
                    umbrella = D;
                }

                if (umbrella > 0) {
                    umbrella--;
                } else {
                    hp--;
                }


                if (umbrella + hp > visited[x][y]) {
                    queue.add(new int[]{x, y, now[2] + 1, umbrella, hp});
                    visited[x][y] = umbrella + hp;
                }
            }
        }
    }
}