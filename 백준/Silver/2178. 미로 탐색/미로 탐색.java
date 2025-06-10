import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] miro = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                miro[i][j] = line[j] - '0';
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        queue.add(new int[]{0, 0, 1});
        visit[0][0] = true;

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        int answer = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == N - 1 && now[1] == M - 1) {
                answer = now[2];
                break;
            }

            for (int k = 0; k < 4; k++) {
                int ny = now[0] + dy[k];
                int nx = now[1] + dx[k];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if (visit[ny][nx] || miro[ny][nx] == 0) continue;

                queue.add(new int[]{ny, nx, now[2] + 1});
                visit[ny][nx] = true;
            }
        }

        System.out.println(answer);
    }
}