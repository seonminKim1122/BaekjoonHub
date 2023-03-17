import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            sum += numbers[i];
        }

        // 산술 평균
        long arithmeticMean = Math.round((double) sum / (double) N);
        System.out.println(arithmeticMean);

        // 중앙값
        Arrays.sort(numbers);
        int idx = numbers.length/2;
        System.out.println(numbers[idx]);

        // 최빈값
        int[] count = new int[8001];
        // {1, 3, 8, -2, 2}
        // {-2, 1, 2, 3, 8}
        // {-3, -2, -2, -1, -1}
        int maxCount = 0;
        for (int i = 0; i < N; i++) {
            count[numbers[i]+4000]++;
            maxCount = Math.max(maxCount, count[numbers[i]+4000]);
        }

        int mode = 0;
        int numOfMode = 0;
        for (int i = 0; i < 8001; i++) {
            if (count[i] == maxCount) {
                // i - 4000이 실제 값
                mode = i - 4000;
                if (++numOfMode == 2) {
                    break;
                }
            }
        }
        System.out.println(mode);

        // 범위
        int max = numbers[numbers.length-1];
        int min = numbers[0];
        System.out.println(max - min);
    }
}