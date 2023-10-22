import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static char[][] board;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        boolean[][] visited1 = new boolean[N][N];
        boolean[][] visited2 = new boolean[N][N];

        int numOfDistrict1= 0;
        int numOfDistrict2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited1[i][j]) {
                    dfs1(i, j, visited1);
                    numOfDistrict1++;
                }

                if (!visited2[i][j]) {
                    dfs2(i, j, visited2);
                    numOfDistrict2++;
                }
            }
        }

        System.out.println(numOfDistrict1 + " " + numOfDistrict2);
    }

    public static void dfs1(int i, int j, boolean[][] visited) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || y < 0 || x >= N || y >= N || visited[x][y] || board[i][j] != board[x][y]) continue;

            dfs1(x, y, visited);
        }
    }

    public static void dfs2(int i , int j, boolean[][] visited) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || y < 0 || x >= N || y >= N || visited[x][y]) continue;

            int diff = Math.abs(board[i][j] - board[x][y]);

            if (diff == 11 || diff == 0) { // R : 82, G : 71, B : 66
                dfs2(x, y, visited);
            }
        }
    }
}