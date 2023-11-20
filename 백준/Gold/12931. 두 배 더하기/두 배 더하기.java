import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        while (true) {
            for (int i = 0; i < N; i++) {
                if (numbers[i] % 2 != 0) {
                    numbers[i]--;
                    result++;
                }
                numbers[i] /= 2;
            }

            if (isZeroArray(numbers)) {
                break;
            }

            result++;
        }

        System.out.println(result);
    }

    public static boolean isZeroArray(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] != 0) return false;
        }

        return true;
    }
}