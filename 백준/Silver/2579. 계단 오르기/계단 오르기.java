import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        N번째 계단에 도달하는 방법
        : N - 2번째 계단에서 2칸 점프
        : N - 3, N - 1, N 순서로 이동
         */
        int N = Integer.parseInt(br.readLine()); // 계단의 개수
        int[] steps = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }

        int[] result = new int[N + 1];
        result[1] = steps[1];

        if (N == 1) {
            System.out.println(result[N]);
            return;
        }

        result[2] = steps[1] + steps[2];
        for (int i = 3; i <= N; i++) {
            result[i] = Math.max(result[i - 2], result[i - 3] + steps[i - 1]) + steps[i];
        }

        System.out.println(result[N]);
    }
}