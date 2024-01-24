import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] solutions = new int[N]; // 오름차순으로 정렬된 상태
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = N - 1;

        int solution1 = 0;
        int solution2 = 0;
        int diff = 2_000_000_001; // 혼합 용액이 0 과의 거리는 최대 2_000_000_000
        while (start < end) {
            int mix = solutions[start] + solutions[end];
            
            if (mix < 0) { // 음수면 start++
                if (-mix <= diff) {
                    diff = -mix;
                    solution1 = solutions[start];
                    solution2 = solutions[end];
                }
                start++;
            } else if (mix > 0) {
                if (mix <= diff) {
                    diff = mix;
                    solution1 = solutions[start];
                    solution2 = solutions[end];
                }
                end--;
            } else { // 0 찾았으면 끝
                solution1 = solutions[start];
                solution2 = solutions[end];
                break;
            }
        }

        System.out.println(solution1 + " " + solution2);
    }
}