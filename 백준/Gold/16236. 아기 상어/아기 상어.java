import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int time = 0;
    static int numOfEat = 0;
    static int sharkSize = 2;
    static int[] position = new int[2];
    static int[][] area;
    static int N;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        area = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if (area[i][j] == 9) {
                    position[0] = i;
                    position[1] = j;
                    area[i][j] = 0;
                }
            }
        }

        while (true) {
            if (!eat()) break;
        }

        System.out.println(time);
    }

    public static boolean eat() {
        boolean flag = false;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{position[0], position[1], 0});

        boolean[][] visited = new boolean[N][N];
        visited[position[0]][position[1]] = true;

        int[] fish = {N, N};
        int distance = N * N;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[2] >= distance) continue;

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
                if (area[nx][ny] > sharkSize) continue;

                if (0 < area[nx][ny] && area[nx][ny] < sharkSize) {
                    flag = true;
                    distance = now[2] + 1;
                    if (fish[0] > nx || (fish[0] == nx && fish[1] > ny)) {
                        fish[0] = nx;
                        fish[1] = ny;
                    }
                }

                queue.add(new int[]{nx, ny, now[2] + 1});
                visited[nx][ny] = true;
            }
        }

        if (flag) {
            area[fish[0]][fish[1]] = 0;
            time += distance;
            numOfEat += 1;
            if (numOfEat == sharkSize) {
                sharkSize += 1;
                numOfEat = 0;
            }
            position[0] = fish[0];
            position[1] = fish[1];
        }

        return flag;
    }
}