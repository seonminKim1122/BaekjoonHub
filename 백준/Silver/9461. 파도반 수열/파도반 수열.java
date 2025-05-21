import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수열의 관계: An = An-1 + An-5
        long[] sequence = new long[101];
        sequence[1] = 1;
        sequence[2] = 1;
        sequence[3] = 1;
        sequence[4] = 2;
        for (int i = 5; i <= 100; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 5];
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while (T > 0) {
            T--;

            int N = Integer.parseInt(br.readLine());
            answer.append(sequence[N]).append("\n");
        }

        System.out.println(answer);
    }
}