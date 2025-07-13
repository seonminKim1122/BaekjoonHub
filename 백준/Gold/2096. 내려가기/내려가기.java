import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int INF = 100000 * 999;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(max(board, N) + " " + min(board, N));
    }

    static int max(int[][] board, int N) {

        int[][] scores = new int[N][3];
        scores[0] = board[0];

        for (int i = 1; i < N; i++) {
            scores[i][0] = Math.max(scores[i - 1][0], scores[i - 1][1]) + board[i][0];
            scores[i][1] = Math.max(Math.max(scores[i - 1][0], scores[i - 1][1]), scores[i - 1][2]) + board[i][1];
            scores[i][2] = Math.max(scores[i - 1][1], scores[i - 1][2]) + board[i][2];
        }

        return Math.max(Math.max(scores[N - 1][0], scores[N - 1][1]), scores[N - 1][2]);
    }

    static int min(int[][] board, int N) {

        int[][] scores = new int[N][3];
        scores[0] = board[0];

        for (int i = 1; i < N; i++) {
            scores[i][0] = Math.min(scores[i - 1][0], scores[i - 1][1]) + board[i][0];
            scores[i][1] = Math.min(Math.min(scores[i - 1][0], scores[i - 1][1]), scores[i - 1][2]) + board[i][1];
            scores[i][2] = Math.min(scores[i - 1][1], scores[i - 1][2]) + board[i][2];
        }

        return Math.min(Math.min(scores[N - 1][0], scores[N - 1][1]), scores[N - 1][2]);
    }
}