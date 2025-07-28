import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int DIV = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        int[][] matrix = new int[][]{{1, 1}, {1, 0}};
        int[][] fiboMatrix = power(matrix, n);

        System.out.println(fiboMatrix[1][0]);
    }

    public static int[][] power(int[][] matrix, long n) {
        if (n == 0) {
            return new int[][]{{1, 0}, {0, 1}};
        } else if (n == 1) {
            return matrix;
        }

        int[][] temp = power(matrix, n / 2);
        if (n % 2 == 0) {
            return multiply(temp, temp);
        } else {
            return multiply(multiply(temp, temp), matrix);
        }
    }

    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        
        int num1 = (int)((((long)matrix1[0][0] * (long)matrix2[0][0]) % DIV + ((long)matrix1[0][1] * (long)matrix2[1][0]) % DIV) % DIV);
        int num2 = (int)((((long)matrix1[0][0] * (long)matrix2[0][1]) % DIV + ((long)matrix1[0][1] * (long)matrix2[1][1]) % DIV) % DIV);
        int num3 = (int)((((long)matrix1[1][0] * (long)matrix2[0][0]) % DIV + ((long)matrix1[1][1] * (long)matrix2[1][0]) % DIV) % DIV);
        int num4 = (int)((((long)matrix1[1][0] * (long)matrix2[0][1]) % DIV + ((long)matrix1[1][1] * (long)matrix2[1][1]) % DIV) % DIV);

        return new int[][]{{num1, num2}, {num3, num4}};
    }

}