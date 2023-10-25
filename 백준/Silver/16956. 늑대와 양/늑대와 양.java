import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] pasture;
    static boolean[][] visited;

    static int R;
    static int C;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int result = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        pasture = new char[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                pasture[i][j] = input.charAt(j);
            }
        }

        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (pasture[i][j] == 'W') {
                    // dfs
                    dfs(i, j);
                }

                if (result == 0) {
                    System.out.println(result);
                    return;
                }
            }
        }

        System.out.println(result);
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(pasture[i][j]);
            }
            System.out.println();
        }
    }

    public static void dfs(int i, int j) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || y < 0 || x >= R || y >= C || visited[x][y]) continue;
            if (pasture[x][y] == 'D') continue;

            if (pasture[x][y] == 'S') {
                if (pasture[i][j] == '.') {
                    pasture[i][j] = 'D';
                } else if (pasture[i][j] == 'W'){ // 양 바로 옆에 늑대면 막을 수 없음
                    result = 0;
                    return;
                }
            } else {
                dfs(x, y);
            }
        }
    }
}