import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = line[j] - '0';
            }
        }

        List<Integer> answer = new ArrayList<>();
        boolean[][] visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j] || map[i][j] == 0) continue;

                answer.add(bfs(visit, map, i, j, N));
            }
        }

        Collections.sort(answer);

        StringBuilder result = new StringBuilder();
        result.append(answer.size());
        for (int num : answer) {
            result.append("\n").append(num);
        }

        System.out.println(result);
    }

    private static int bfs(boolean[][] visit, int[][] map, int i, int j, int N) {
        int result = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visit[i][j] = true;
        result++;

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int k = 0; k < 4; k++) {
                int ny = now[0] + dy[k];
                int nx = now[1] + dx[k];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                if (visit[ny][nx] || map[ny][nx] == 0) continue;

                queue.add(new int[]{ny, nx});
                visit[ny][nx] = true;
                result++;
            }
        }

        return result;
    }
}