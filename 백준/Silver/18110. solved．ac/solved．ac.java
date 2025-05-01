import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 아직 아무 의견이 없으면 0
        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
        int except = calcExceptCnt(n, 15);

        System.out.println(solve(scores, except));
    }

    private static int calcExceptCnt(int n, int percent) {
        return round(n * percent, 100);
    }

    private static int solve(int[] scores, int except) {
        // 오름차순 정렬
        Arrays.sort(scores);

        // 위 아래에서 except 명씩 제외하고 평균 구하기
        int cnt = scores.length - 2 * except;

        int result = 0;
        for (int i = except; i < except + cnt; i++) {
            result += scores[i];
        }

        return round(result, cnt);
    }

    private static int round(int numerator, int denominator) {
        if (2 * (numerator % denominator) < denominator) {
            return numerator / denominator;
        } else {
            return numerator / denominator + 1;
        }
    }
}