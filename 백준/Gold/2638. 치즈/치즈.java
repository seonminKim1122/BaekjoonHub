import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    static int N;
    static int M;
    // 백준 문제 풀이용 파일입니다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Queue<int[]> cheese = new LinkedList<>();
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) cheese.add(new int[]{i, j});
            }
        }

        int T = 0;
        while (!cheese.isEmpty()) {
            T++;
            // melt()
            dfs(0, 0, map, T);
            melt(map, cheese);
        }

        System.out.println(T);
    }

    public static void dfs(int i, int j, int[][] map, int T) {
        map[i][j] = -T;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (map[nx][ny] == -T | map[nx][ny] == 1) continue;

            dfs(nx, ny, map, T);
        }
    }

    public static void melt(int[][] map, Queue<int[]> cheese) {
        int len = cheese.size();

        for (int i = 0; i < len; i++) {
            int[] now = cheese.poll();
            int cnt = 0;
            for (int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] < 0) cnt++;
            }
            if (cnt >= 2) map[now[0]][now[1]] = 0;
            else cheese.add(now);
        }
    }
}