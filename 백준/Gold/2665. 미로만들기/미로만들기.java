import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int[][] change = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                change[i][j] = N * N;
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[0] - o2[0]));
        change[0][0] = 0;
        pq.add(new int[]{change[0][0], 0, 0});

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            int cost = now[0];
            int x = now[1];
            int y = now[2];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                int nextCost = cost + (map[nx][ny]  + 1) % 2;
                if (nextCost >= change[nx][ny]) continue;

                change[nx][ny] = nextCost;
                pq.add(new int[]{change[nx][ny], nx, ny});
            }
        }

        System.out.println(change[N - 1][N - 1]);
    }
}