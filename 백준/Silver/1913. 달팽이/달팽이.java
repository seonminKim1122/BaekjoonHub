import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int value = N * N;
        int[][] board = new int[N][N];

        int i = 0;
        int j = 0;
        board[i][j] = value--;
        int direction = 0;
        while (value > 0) {

            boolean move = false;
            switch (direction) {
                case 0: // 아래
                    if (canMove(board, i + 1, j)) {
                        board[++i][j] = value--;
                        move = true;
                    }
                    break;
                case 1: // 오른쪽
                    if (canMove(board, i, j + 1)) {
                        board[i][++j] = value--;
                        move = true;
                    }
                    break;
                case 2: // 위
                    if (canMove(board, i - 1, j)) {
                        board[--i][j] = value--;
                        move = true;
                    }
                    break;
                default: // 왼쪽
                    if (canMove(board, i, j - 1)) {
                        board[i][--j] = value--;
                        move = true;
                    }
            }

            if (!move) {
                direction = (direction + 1) % 4;
            }
        }

        int targetX = -1;
        int targetY = -1;
        StringBuilder answer = new StringBuilder();
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                answer.append(board[x][y]).append(" ");
                if (board[x][y] == target) {
                    targetX = x + 1;
                    targetY = y + 1;
                }
            }
            answer.append("\n");
        }
        answer.append(targetX).append(" ").append(targetY);

        System.out.println(answer);
    }

    public static boolean canMove(int[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board.length) return false;
        if (board[i][j] != 0) return false;

        return true;
    }
}