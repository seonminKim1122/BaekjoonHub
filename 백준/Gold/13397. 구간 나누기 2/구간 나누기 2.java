import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            if (min > numbers[i]) {
                min = numbers[i];
            }

            if (max < numbers[i]) {
                max = numbers[i];
            }
        }

        int start = 0;
        int end = max - min;

        while (start <= end) {
            int mid = (start + end) / 2;

            int temp = calcNumOfGroup(mid, numbers);

            if (temp <= M) { // 그룹이 적다 -> mid 를 좀 낮추자
                end = mid - 1;
            } else { // 그룹이 많다 -> mid 를 키우자
                start = mid + 1;
            }
        }

        System.out.println(start);
    }

    public static int calcNumOfGroup(int mid, int[] numbers) {
        int result = 1;
        // 각 구간의 점수 => 구간의 최대값 - 최소값
        int minTemp = numbers[0]; // 일단 가장 첫 숫자는 구간에 포함
        int maxTemp = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minTemp) {
                minTemp = numbers[i];
            }

            if (numbers[i] > maxTemp) {
                maxTemp = numbers[i];
            }

            if (maxTemp - minTemp > mid) { // 이럼 같은 구간에 포함될 수 없으므로 구간 그룹 하나 추가
                result++;
                minTemp = numbers[i];
                maxTemp = numbers[i];
            }
        }

        return result;
    }
}