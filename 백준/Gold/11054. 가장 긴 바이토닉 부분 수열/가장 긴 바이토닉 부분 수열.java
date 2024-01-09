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

        int[] LCS = new int[N];
        int[] LDS = new int[N];

        for (int i = 0; i < N; i++) {
            LCS[i] = 1;
            LDS[N - 1 - i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    LCS[i] = Math.max(LCS[i], LCS[j] + 1);
                }

                if (numbers[N - 1 - i] > numbers[N - 1 - j]) {
                    LDS[N - 1 - i] = Math.max(LDS[N - 1 - i], LDS[N - 1 - j] + 1);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, LCS[i] + LDS[i] - 1);
        }

        System.out.println(result);
    }
}