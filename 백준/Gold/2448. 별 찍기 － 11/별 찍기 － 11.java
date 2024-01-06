import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        board = new char[N][2 * N - 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                board[i][j] = ' ';
            }
        }

        draw(0, 0, N);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                result.append(board[i][j]);
            }
            result.append("\n");
        }

        System.out.println(result);
    }

    public static void draw(int i, int j, int N) {
        if (N == 3) {
            board[i][j + 2] = '*';
            board[i + 1][j + 1] = board[i + 1][j + 3] = '*';
            board[i + 2][j] = board[i + 2][j + 1] = board[i + 2][j + 2] = board[i + 2][j + 3] = board[i + 2][j + 4] = '*';
            return;
        }

        draw(i, j + N / 2, N / 2);
        draw(i + N / 2, j, N / 2);
        draw(i + N / 2, j + N, N / 2);
    }
}