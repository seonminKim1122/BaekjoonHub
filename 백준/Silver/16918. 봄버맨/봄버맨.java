import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] board = new char[R][C];
        int[][] timeForExplode = new int[R][C];
        for (int i = 0; i < R; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                board[i][j] = input[j];
                timeForExplode[i][j] = 2;
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        N--;
        while (N > 0) {
            // 1초 동안 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다.
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] == '.') {
                        board[i][j] = 'O';
                        timeForExplode[i][j] = 3;
                    } else {
                        timeForExplode[i][j] = timeForExplode[i][j] - 1;
                    }
                }
            }
            N--;
            if (N == 0) break;

            // 1초가 지난 후에 3초 전에 설치 된 폭탄이 모두 폭발한다.
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    timeForExplode[i][j] = timeForExplode[i][j] - 1;
                    if (timeForExplode[i][j] == 0) { // 폭탄들이 동시에 터져야 하는데 이러면 순차적으로 터짐
                        board[i][j] = '.';
                        for (int k = 0; k < 4; k++) {
                            int x = i + dx[k];
                            int y = j + dy[k];

                            if (x < 0 || y < 0 || x >= R || y >= C || timeForExplode[x][y] == 0) continue;
                            board[x][y] = '.';
                        }
                    }
                }
            }
            N--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}