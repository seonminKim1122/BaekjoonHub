import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 행렬의 거듭제곱
        int[][] result = power(A, B);
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer.append(result[i][j] % 1000).append(" ");
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }

    public static int[][] power(int[][] A, long B) {
        if (B == 0) {
            int N = A.length;
            int[][] result = new int[N][N];
            for (int i = 0; i < N; i++) {
                result[i][i] = 1;
            }
            return result;
        }

        if (B == 1) {
            return A;
        }

        if (B == 2) {
            return multiply(A, A);
        }

        int[][] temp = power(A, B / 2);

        if (B % 2 == 0) {
            return power(temp, 2);
        } else {
            return multiply(power(temp, 2), A);
        }
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        int R = A.length;
        int C = B[0].length;

        int[][] result = new int[R][C];
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {

                for (int k = 0; k < A[i].length; k++) {
                    result[i][j] += (A[i][k] * B[k][j]);
                    result[i][j] %= 1000;
                }

            }
        }

        return result;
    }
}