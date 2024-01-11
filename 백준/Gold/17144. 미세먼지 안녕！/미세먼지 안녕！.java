import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Main {

    static int R;
    static int C;
    static List<Integer> airCleaner = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] room = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == -1) airCleaner.add(i);
            }
        }

        while (T > 0) {
            diffusion(room);
            runAirCleaner(room);
            T--;
        }

        System.out.println(sumOfDust(room));
    }

    public static void diffusion(int[][] room) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] newRoom = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] > 0) queue.add(new int[]{i, j});
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            int x = now[0];
            int y = now[1];

            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (room[nx][ny] == -1) continue;

                newRoom[nx][ny] += (room[x][y] / 5);
                cnt++;
            }

            room[x][y] -= (cnt * (room[x][y] / 5));
            // 확산의 동시에 일어나야 하는데 단순 bfs() 로직으로는 동시에 일어나지 않음
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                room[i][j] += newRoom[i][j];
            }
        }
    }

    public static void runAirCleaner(int[][] room) {
        int upper = airCleaner.get(0);
        int lower = airCleaner.get(1);
        // 위쪽
        for (int i = upper - 1; i > 0; i--) {
            room[i][0] = room[i - 1][0];
        }

        for (int j = 0; j < C - 1; j++) {
            room[0][j] = room[0][j + 1];
        }

        for (int i = 0; i < upper; i++) {
            room[i][C - 1] = room[i + 1][C - 1];
        }

        for (int j = C - 1; j > 0; j--) {
            room[upper][j] = room[upper][j - 1];
            if (j == 1) room[upper][j] = 0;
        }

        // 아래쪽
        for (int i = lower + 1; i < R - 1; i++) {
            room[i][0] = room[i + 1][0];
        }

        for (int j = 0; j < C - 1; j++) {
            room[R - 1][j] = room[R - 1][j + 1];
        }

        for (int i = R - 1; i > lower; i--) {
            room[i][C - 1] = room[i - 1][C - 1];
        }

        for (int j = C - 1; j > 0; j--) {
            room[lower][j] = room[lower][j - 1];
            if (j == 1) room[lower][j] = 0;
        }
    }

    public static int sumOfDust(int[][] room) {
        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] > 0) result += room[i][j];
            }
        }

        return result;
    }
}