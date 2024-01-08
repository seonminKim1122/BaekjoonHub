import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] I;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] A = new int[N][N];
        I = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
            I[i][i] = 1;
        }

        int[][] result = exp(A, B);

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer.append(result[i][j]).append(" ");
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }

    public static int[][] exp(int[][] A, long B) {
        if (B == 1) return multiply(A, I);

        int[][] temp = exp(A, B / 2);
        if (B % 2 == 0) {
            return multiply(temp, temp);
        } else {
            return multiply(A, multiply(temp, temp));
        }
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += (A[i][k] * B[k][j]);
                    result[i][j] %= 1000;
                }
            }
        }

        return result;
    }
}