import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {-1, 1, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {

            char[][] board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                String input = br.readLine();
                for (int j = 0; j < 3; j++) {
                    board[i][j] = input.charAt(j);
                }
            }

            Queue<Case> queue = new LinkedList<>();
            boolean[] visited = new boolean[1 << 9];
            queue.add(new Case(board, 0));
            visited[boardToBinary(board)] = true;

            int answer = 10;
            while (!queue.isEmpty()) {
                Case now = queue.poll();

                if (now.isWhiteBoard()) {
                    answer = now.cntOfClick;
                    break;
                }

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (now.board[i][j] == '*') {
                            for (int k = 0; k < 5; k++) {
                                int x = i + dx[k];
                                int y = j + dy[k];

                                if (x < 0 || y < 0 || x >= 3 || y >= 3) continue;
                                
                                char[][] newBoard = clickBoard(now.board, x, y);
                                int binary = boardToBinary(newBoard);
                                if (visited[binary]) continue;
                                
                                queue.add(new Case(newBoard, now.cntOfClick + 1));
                                visited[binary] = true;
                            }
                        }
                    }
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    static char[][] clickBoard(char[][] board, int i, int j) {
        char[][] result = new char[3][3];
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                result[k][l] = board[k][l];
            }
        }
        
        for (int k = 0; k < 5; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || y < 0 || x >= 3 || y >= 3) continue;
            if (result[x][y] == '.') {
                result[x][y] = '*';
            } else {
                result[x][y] = '.';
            }
        }

        return result;
    }

    static int boardToBinary(char[][] board) {
        int result = 0;
        int jinsu = 1;
        for (int i = 2; i >= 0; i--) {
            for (int j = 2; j >= 0; j--) {
                if (board[i][j] == '*') result += jinsu;
                jinsu *= 2;
            }
        }

        return result;
    }

    static class Case {
        char[][] board;
        int cntOfClick;

        Case (char[][] board, int cntOfClick) {
            this.board = board;
            this.cntOfClick = cntOfClick;
        }

        boolean isWhiteBoard() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] != '.') return false;
                }
            }
            return true;
        }
    }
}