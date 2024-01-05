import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        int start = 0;
        int end = 5 * M;

        while (start <= end) {
            int N = (start + end) / 2;

            int cnt = cntOfZero(N);
            if (cnt >= M) {
                end = N - 1;
            } else {
                start = N + 1;
            }
        }

        System.out.println(cntOfZero(start) == M ? start : -1);
    }

    public static int cntOfZero(int N) {
        int result = 0;

        for (int i = 5; i <= N; i *= 5) {
            result += (N / i);
        }

        return result;
    }
}