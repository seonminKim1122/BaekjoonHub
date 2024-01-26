import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] LIS = new int[N];
        int[] trace = new int[N];  // trace[i] numbers[i] 숫자가 LIS 어디에 위치하는지
        int endOfLIS = 0;
        LIS[endOfLIS] = numbers[0];
        trace[0] = endOfLIS;

        for (int i = 1; i < N; i++) {
            if (LIS[endOfLIS] < numbers[i]) {
                LIS[++endOfLIS] = numbers[i];
                trace[i] = endOfLIS;
            } else {
                int start = 0;
                int end = endOfLIS;

                while (start < end) {
                    int mid = (start + end) / 2;

                    if (LIS[mid] < numbers[i]) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }

                LIS[start] = numbers[i];
                trace[i] = start;
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append(endOfLIS + 1).append("\n");

        int cur = endOfLIS;
        for (int i = N - 1; i >= 0; i--) {
            if (trace[i] == cur) {
                LIS[cur--] = numbers[i];
            }
        }

        for (int i = 0; i <= endOfLIS; i++) {
            answer.append(LIS[i]).append(" ");
        }

        System.out.println(answer);
    }
}
/*
6
1 3 5 7 2 3 -> 3의 재갱신 현상을 어떻게 처리할 것인가? 내가 쓰는 방식은 재갱신 문제 해결 못함
-> HashSet 을 이용해 3의 가능한 위치들을 다 저장해놓고 찾기?


정답 - 1 3 5 7
출력 - 1 2 5 7

10
1 3 5 7 2 3 4 5 6 7
정답 - 1 2 3 4 5 6 7
출력 - 1 2 3 4 5 6 7
*/