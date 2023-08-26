import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int result = Integer.MAX_VALUE;
    static int N;
    static int[][] prices;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        prices = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                prices[i][j] = Integer.parseInt(input[j]);
            }
        }

        dfs(0, 0);

        System.out.println(result);
    }

    public static void dfs(int cnt, int sum) {
        if (cnt == 3) {
            result = Math.min(result, sum);
            return;
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (isAvailable(i, j)) {
                        int temp = sumOfPrices(i, j);
                        dfs(cnt + 1, sum + temp);
                        undoVisit(i, j);
                    }
                }
            }
        }
    }

    public static boolean isAvailable(int i, int j) {
        for (int k = 0; k < 5; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || y < 0 || x >= N || y >= N || visited[x][y]) return false;
        }

        return true;
    }

    public static int sumOfPrices(int i, int j) {
        int sum = 0;
        for (int k = 0; k < 5; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            sum += prices[x][y];
            visited[x][y] = true;
        }

        return sum;
    }

    public static void undoVisit(int i, int j) {
        for (int k = 0; k < 5; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            visited[x][y] = false;
        }
    }
}