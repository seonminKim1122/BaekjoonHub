import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] =  br.readLine().toCharArray();;
        }


        int normal = 0;
        int week = 0;
        boolean[][] normalVisit = new boolean[N][N];
        boolean[][] weekVisit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!normalVisit[i][j]) {
                    normalDfs(map, i, j, normalVisit);
                    normal++;
                }

                if (!weekVisit[i][j]) {
                    weekDfs(map, i, j, weekVisit);
                    week++;
                }
            }
        }

        System.out.println(normal + " " + week);
    }

    private static void normalDfs(char[][] map, int y, int x, boolean[][] visit) {
        visit[y][x] = true;

        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
            if (visit[ny][nx]) continue;
            if (map[ny][nx] != map[y][x]) continue;

            normalDfs(map, ny, nx, visit);
        }
    }

    private static void weekDfs(char[][] map, int y, int x, boolean[][] visit) {
        visit[y][x] = true;

        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
            if (visit[ny][nx]) continue;
            if (map[y][x] == 'B' && map[y][x] != map[ny][nx]) continue;
            if ((map[y][x] == 'R' || map[y][x] == 'G') && map[ny][nx] == 'B') continue;

            weekDfs(map, ny, nx, visit);
        }
    }

}
