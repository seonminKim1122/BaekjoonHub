import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long[][] arr = {{1, 1}, {1, 0}};

        System.out.println(fibonacci(arr, n - 1)[0][0]);
    }

    public static long[][] fibonacci(long[][] arr, long exp) {
        if (exp == 1 || exp == 0) return arr;

        long[][] result = fibonacci(arr, exp / 2);

        result = multiply(result, result);

        if (exp % 2 == 1) {
            result = multiply(result, arr);
        }

        return result;
    }

    public static long[][] multiply(long[][] arr1, long[][] arr2) {
        long[][] result = new long[2][2];

        result[0][0] = (arr1[0][0] * arr2[0][0] + arr1[0][1] * arr2[1][0]) % 1_000_000_007;
        result[0][1] = (arr1[0][0] * arr2[0][1] + arr1[0][1] * arr2[1][1]) % 1_000_000_007;
        result[1][0] = (arr1[1][0] * arr2[0][0] + arr1[1][1] * arr2[1][0]) % 1_000_000_007;
        result[1][1] = (arr1[1][0] * arr2[0][1] + arr1[1][1] * arr2[1][1]) % 1_000_000_007;

        return result;
    }
}