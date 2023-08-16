import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int houses = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        boolean[][] visited = new boolean[N][N];
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, map, visited);
                    results.add(houses);
                    houses = 0;
                }
            }
        }

        Collections.sort(results);
        StringBuilder sb = new StringBuilder();
        sb.append(results.size()).append("\n");
        for (int result : results) {
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int i, int j, int[][] map, boolean[][] visited) {
        visited[i][j] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || y < 0 || x >= map.length || y >= map.length || visited[x][y] || map[x][y] == 0) continue;

            dfs(x, y, map, visited);
        }
        houses++;
    }
}