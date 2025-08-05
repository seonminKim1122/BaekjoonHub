import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] board = new char[R][C];
        for (int r = 0; r < R; r++) {
            char[] line = br.readLine().toCharArray();
            for (int c = 0; c < C; c++) {
                board[r][c] = line[c];
            }
        }

        boolean[] inPath = new boolean[26];
        inPath[board[0][0] - 'A'] = true;
        dfs(board, 0, 0, inPath, R, C, 1);

        System.out.println(answer);
    }

    static void dfs(char[][] board, int r, int c, boolean[] inPath
                  , int R, int C, int cnt) {

        answer = Math.max(answer, cnt);

        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
            if (inPath[board[nr][nc] - 'A']) continue;

            inPath[board[nr][nc] - 'A'] = true;
            dfs(board, nr, nc, inPath, R, C, cnt + 1);
            inPath[board[nr][nc] - 'A'] = false;
        }
    }
}