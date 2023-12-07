import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[][] grid;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int H;
    static int W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder results = new StringBuilder();
        while (T --> 0) {
            String[] input = br.readLine().split(" ");

            H = Integer.parseInt(input[0]);
            W = Integer.parseInt(input[1]);

            grid = new char[H][W];
            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                    grid[i][j] = line.charAt(j);
                }
            }

            int result = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (grid[i][j] == '#') {
                        dfs(i, j);
                        result++;
                    }
                }
            }

            results.append(result).append("\n");
        }

        System.out.println(results);
    }

    private static void dfs(int i, int j) {
        grid[i][j] = '.';

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || y < 0 || x >= H || y >= W || grid[x][y] == '.') continue;

            dfs(x, y);
        }
    }
}