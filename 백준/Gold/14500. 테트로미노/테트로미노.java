import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        boolean[][] visit = new boolean[N][M];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                answer = Math.max(answer, solve(map, visit, i, j, 0, map[i][j], N, M));
            }
        }

        System.out.println(answer);
    }

    public static int solve(int[][] map, boolean[][] visit, int y, int x, int depth, int sum, int N, int M) {
        if (depth == 3) {
            return sum;
        }

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        int result = 0;
        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
            if (visit[ny][nx]) continue;

            visit[ny][nx] = true;
            result = Math.max(result, solve(map, visit, ny, nx, depth + 1, sum + map[ny][nx], N, M));
            result = Math.max(result, solve(map, visit, y, x, depth + 1, sum + map[ny][nx], N, M));
            visit[ny][nx] = false;
        }


        return result;
    }
}
