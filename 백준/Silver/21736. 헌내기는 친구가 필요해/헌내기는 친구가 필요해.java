import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] campus = new char[N][M];

        int startY = -1;
        int startX = -1;
        for (int y = 0; y < N; y++) {
            String info = br.readLine();
            for (int x = 0; x < M; x++) {
                campus[y][x] = info.charAt(x);
                if (campus[y][x] == 'I') {
                    startY = y;
                    startX = x;
                }
            }
        }

        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        int cnt = 0;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        queue.add(new int[]{startY, startX});
        visit[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int ny = now[0] + dy[d];
                int nx = now[1] + dx[d];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if (visit[ny][nx]) continue;
                if (campus[ny][nx] == 'X') continue;

                queue.add(new int[]{ny, nx});
                visit[ny][nx] = true;
                if (campus[ny][nx] == 'P') {
                    cnt++;
                }
            }
        }

        if (cnt == 0) {
            System.out.println("TT");
        } else {
            System.out.println(cnt);
        }
    }

}