import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] LDS = new int[N];  // LDS[i]: 0 ~ i 까지의 부분 수열 중 numbers[i]를 포함한 가장 긴 감소하는 부분 수열의 길이
        int answer = 0;
        for (int i = 0; i < N; i++) {
            LDS[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[j] > numbers[i]) {
                    LDS[i] = Math.max(LDS[i], LDS[j] + 1);
                }
            }
            answer = Math.max(answer, LDS[i]);
        }

        System.out.println(answer);
    }
}
