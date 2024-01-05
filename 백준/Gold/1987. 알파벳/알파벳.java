import java.io.*;
import java.util.*;

public class Main {

    static int result = 0;    
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static char[][] board;    
    static boolean[] visited = new boolean[26];

    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);
            }
        }
				
		visited[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(result);
    }

    public static void dfs(int i, int j, int depth) {
        result = Math.max(result, depth);

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if (visited[board[nx][ny] - 'A']) continue;

            visited[board[nx][ny] - 'A'] = true;
            dfs(nx, ny, depth + 1);
            visited[board[nx][ny] - 'A'] = false;
        }
    }
}