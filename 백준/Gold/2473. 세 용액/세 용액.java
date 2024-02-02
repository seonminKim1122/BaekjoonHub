import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] results = new int[3];
    static int[] solutions;
    static long result = 1_000_000_000 * 5001L;

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        solutions = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(solutions);

        for (int solution1 = 0; solution1 < N - 2; solution1++) {
            for (int solution2 = solution1 + 1; solution2 < N - 1; solution2++) {
                long temp = bs(solution1, solution2);
                if (temp == 0) break;
            }
        }


        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            answer.append(results[i]).append(' ');
        }
        System.out.println(answer);
    }

    static int bs(int solution1, int solution2) {
        int start = solution2 + 1;
        int end = solutions.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            long temp = (long)solutions[solution1] + solutions[solution2] + solutions[mid];

            if (result > Math.abs(temp)) {
                result = Math.abs(temp);
                results[0] = solutions[solution1];
                results[1] = solutions[solution2];
                results[2] = solutions[mid];
            }

            if (temp < 0) {
                start = mid + 1;
            } else if (temp > 0) {
                end = mid - 1;
            } else {
                return 0;
            }
        }

        return -1;
    }
}
/*
의사코드
1. solution1 포인터, solution2 포인터 2중 for 문으로 가능한 모든 케이스 탐색
2. solution3 포인터는 solution2 포인터 이후 부분 중에서 Binary Search 로 최적화
 */