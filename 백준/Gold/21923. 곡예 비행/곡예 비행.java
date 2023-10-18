import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] scoreBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                scoreBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] ascending = new int[N][M];
        int[][] descending = new int[N][M];

        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                if (i + 1 < N && j - 1 >= 0) {
                    ascending[i][j] = Math.max(ascending[i + 1][j], ascending[i][j - 1]);
                }
                if (i + 1 >= N && j - 1 >= 0) {
                    ascending[i][j] = ascending[i][j - 1];
                }
                if (i + 1 < N && j - 1 < 0) {
                    ascending[i][j] = ascending[i + 1][j];
                }
                ascending[i][j] += scoreBoard[i][j];
            }

            for (int j = M - 1; j >= 0; j--) {
                if (i + 1 < N && j + 1 < M) {
                    descending[i][j] = Math.max(descending[i + 1][j], descending[i][j + 1]);
                }
                if (i + 1 >= N && j + 1 < M) {
                    descending[i][j] = descending[i][j + 1];
                }
                if (i + 1 < N && j + 1 >= M) {
                    descending[i][j] = descending[i + 1][j];
                }
                descending[i][j] += scoreBoard[i][j];
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int score = ascending[i][j] + descending[i][j];
                result = Math.max(result, score);
            }
        }

        System.out.println(result);
    }
}