import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Main {

    static int[][] laboratory;
    static int[][] origin;
    static List<int[]> blanks = new ArrayList<>();
    static int N;
    static int M;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        origin = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
                if (origin[i][j] == 0) {
                    blanks.add(new int[]{i, j});
                }
            }
        }

        boolean[] visited = new boolean[blanks.size()];
        for (int i = 0; i < blanks.size(); i++) {
            visited[i] = true;
            dfs(i, 1, visited);
            visited[i] = false;
        }

        System.out.println(result);
    }

    public static void dfs(int start, int depth, boolean[] visited) {
        if (depth == 3) {
            laboratory = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    laboratory[i][j] = origin[i][j];
                }
            }

            // 벽 세우기
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    int[] temp = blanks.get(i);
                    laboratory[temp[0]][temp[1]] = 1;
                }
            }

            updateSafeArea(bfs(laboratory));
        } else {
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(i, depth + 1, visited);
                    visited[i] = false;
                }
            }
        }
    }

    public static int[][] bfs(int[][] laboratory) {
        // 바이러스 퍼뜨리기
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (laboratory[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = temp[0] + dx[i];
                int y = temp[1] + dy[i];

                if (x < 0 || y < 0 || x >= N || y >= M || visited[x][y] || laboratory[x][y] != 0) continue;

                queue.add(new int[]{x, y});
                laboratory[x][y] = 2;
                visited[x][y] = true;
            }
        }

        return laboratory;
    }

    public static void updateSafeArea(int[][] laboratory) {
        int temp = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (laboratory[i][j] == 0) {
                    temp++;
                }
            }
        }

        if (result < temp) {
            result = temp;
        }
    }
}