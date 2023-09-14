import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Main {

    static int N;
    static int M;
    static int[][] array;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int result = 0;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[N][M];
        visited = new boolean[N][M];

        Queue<int[]> zeroQueue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                if (array[i][j] == 0) {
                    zeroQueue.add(new int[]{i, j});
                }
            }
        }

        int district = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (array[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, district++);
                }
            }
        }

        while (!zeroQueue.isEmpty()) {
            int[] now = zeroQueue.poll();

            int size = 0;
            Set<Integer> visited = new HashSet<>();
            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x < 0 || y < 0 || x >= N || y >= M || visited.contains(array[x][y])) continue;

                size += map.getOrDefault(array[x][y], 0);
                visited.add(array[x][y]);
            }

            result = Math.max(size, result);
        }

        System.out.println(result + 1);
    }

    public static void bfs(int i, int j, int district) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        array[i][j] = district;

        int size = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x < 0 || y < 0 || x >= N || y >= M || visited[x][y] || array[x][y] == 0) continue;

                queue.add(new int[]{x, y});
                visited[x][y] = true;
                array[x][y] = district;
                size++;
            }
        }

        map.put(district, size);
    }
}