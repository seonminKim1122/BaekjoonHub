import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] scores;
    static boolean[][] visited;
    static int result = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        scores = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, scores[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(result);
    }

    public static void dfs(int i, int j, int sum, int depth) {
        if (depth == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            
            if (x < 0 || y < 0 || x >= N || y >= M || visited[x][y]) continue;

            if (depth == 2) {
                visited[x][y] = true;
                dfs(i, j, sum + scores[x][y], depth + 1);
                visited[x][y] = false;
            }

            visited[x][y] = true;
            dfs(x, y, sum + scores[x][y], depth + 1);
            visited[x][y] = false;
        }
    }
}