import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        List<Integer> counts = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, map, visited);
                    result++;
                    counts.add(count);
                    count = 0;
                }
            }
        }

        System.out.println(result);
        for (int count : counts.stream().sorted().collect(Collectors.toList())) {
            System.out.println(count);
        }
    }

    public static void dfs(int i, int j, int[][] map, boolean[][] visited) {
        if (visited[i][j]) return;

        visited[i][j] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || y < 0 || x >= map.length || y >= map.length || visited[x][y] || map[x][y] != 1) continue;

            dfs(x, y, map, visited);
        }

        count++;
    }
}