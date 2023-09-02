import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

        Arrays.sort(numbers);

        int result = 0;
        for (int i = 0; i < N-2; i++) {
            int x = numbers[i];
            int y = numbers[i + 1];

            for (int j = N - 1; j > i + 1; j--) {
                int z = numbers[j];
                if (x + y > z) {
                    result = Math.max(result, j - i + 1);
                    break;
                }
            }
        }

        if (result == 0) {
            result = Math.min(N, 2);
        }
        System.out.println(result);
    }
}