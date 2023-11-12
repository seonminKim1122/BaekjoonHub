import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String result = "NO";

    static int M;
    static int N;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        grid = new int[M][N];
        for (int i = 0; i < M; i++) {
            String inputN = br.readLine();
            for (int j = 0; j < N; j++) {
                int input = inputN.charAt(j) - '0';
                grid[i][j] = input;
            }
        }

        visited = new boolean[M][N];
        for (int j = 0; j < N; j++) {
            if (result.equals("YES")) break;
            if (grid[0][j] == 0) dfs(0, j);
        }

        System.out.println(result);
    }

    public static void dfs(int i, int j) {
        visited[i][j] = true;
        if (i == visited.length - 1) {
            result = "YES";
            return;
        }

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || y < 0 || x >= M || y >= N || visited[x][y]) continue;
            if (grid[x][y] == 1) continue;
            if (result.equals("YES")) break;
            
            dfs(x, y);
        }
    }
}