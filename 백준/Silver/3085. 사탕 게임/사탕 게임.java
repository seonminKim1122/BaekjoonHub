import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static char[][] board;


    static int result = 0;

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

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 상
                char temp = board[i][j];
                if (i - 1 >= 0 && board[i][j] != board[i - 1][j]) {
                    change(i, j, i - 1, j);
                    // 계산
                    calcMax();
                    // 원위치
                    change(i, j, i - 1, j);
                }
                // 하
                if (i + 1 < N && board[i][j] != board[i + 1][j]) {
                    change(i, j, i + 1, j);
                    // 계산
                    calcMax();
                    // 원위치
                    change(i, j, i + 1, j);
                }
                // 좌
                if (j - 1 >= 0 && board[i][j] != board[i][j - 1]) {
                    change(i, j, i, j - 1);
                    // 계산
                    calcMax();
                    // 원위치
                    change(i, j, i, j - 1);
                }
                // 우
                if (j + 1 < N && board[i][j] != board[i][j + 1]) {
                    change(i, j, i, j + 1);
                    // 계산
                    calcMax();
                    // 원위치
                    change(i, j, i, j + 1);
                }
            }
        }

        System.out.println(result);
    }

    public static void change(int i1, int j1, int i2, int j2) {
        char temp = board[i1][j1];
        board[i1][j1] = board[i2][j2];
        board[i2][j2] = temp;
    }

    public static void calcRowMax(int row) {
        char before = board[row][0];
        int cnt = 1;

        for (int col = 1; col < N; col++) {
            if (before == board[row][col]) {
                cnt++;
            } else {
                result = Math.max(result, cnt);
                before = board[row][col];
                cnt = 1;
            }
        }

        result = Math.max(result, cnt);
    }

    public static void calcColMax(int col) {
        char before = board[0][col];
        int cnt = 1;

        for (int row = 1; row < N; row++) {
            if (before == board[row][col]) {
                cnt++;
            } else {
                result = Math.max(result, cnt);
                before = board[row][col];
                cnt = 1;
            }
        }

        result = Math.max(result, cnt);
    }

    public static void calcMax() {
        for (int i = 0; i < N; i++) {
            calcRowMax(i);
            calcColMax(i);
        }
    }
}