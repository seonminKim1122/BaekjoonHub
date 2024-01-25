import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] numbers;
    static int lenOfLIS = 0;

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] LIS = new int[N];
        LIS[0] = numbers[0];
        lenOfLIS = 1;

        for (int i = 1; i < N; i++) {
            if (LIS[lenOfLIS - 1] < numbers[i]) {
                LIS[lenOfLIS++] = numbers[i];
            } else {
                insertOrChange(LIS, i);
            }
        }

        System.out.println(lenOfLIS);
    }

    public static void insertOrChange(int[] LIS, int idx) {
        int start = 0;
        int end = lenOfLIS - 1;

        while (start < end) { // 이분탐색 쪽 다시 생각하기 numbers[idx] 보다 가장 조금 작은 요소의 다음에 들어가게 해야한다.
            int mid = (start + end) / 2;

            if (LIS[mid] < numbers[idx]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        LIS[start] = numbers[idx];
    }
}