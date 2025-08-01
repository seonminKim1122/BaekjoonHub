import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] board = new char[N][N * 2 - 1];
        drawTriangle(N, 0, N - 1, board);

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                if (board[i][j] != '*') {
                    answer.append(" ");
                } else {
                    answer.append("*");
                }
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }

    static void drawTriangle(int N, int i, int j, char[][] board) { // i, j 를 꼭대기로 하는 N줄 삼각형 별 찍기
        if (N == 3) {
            board[i][j] = '*';

            board[i + 1][j - 1] = '*';
            board[i + 1][j + 1] = '*';

            board[i + 2][j - 2] = '*';
            board[i + 2][j - 1] = '*';
            board[i + 2][j] = '*';
            board[i + 2][j + 1] = '*';
            board[i + 2][j + 2] = '*';
            return;
        }

        drawTriangle(N / 2, i, j, board);
        drawTriangle(N / 2, i + N / 2, j - N / 2, board);
        drawTriangle(N / 2, i + N / 2, j + N / 2, board);
    }
}