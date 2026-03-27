import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] prefix = new int[H + 1];
        int[] suffix = new int[H + 1];
        for (int i = 1; i <= N; i++) {
            int h = Integer.parseInt(br.readLine());

            // 석순
            if (i % 2 == 1) {
                // 1 ~ h 까지 + 1
                prefix[1] += 1;
                prefix[h + 1] -= 1;
            // 종유석
            } else {
                // H ~ (H - h + 1) 까지 + 1
                suffix[H] += 1;
                suffix[H - h] -= 1;
            }
        }

        for (int i = 1; i <= H; i++) {
            prefix[i] += prefix[i - 1];
        }

        for (int i = H; i >= 1; i--) {
            suffix[i - 1] += suffix[i];
        }

        int[] arr = new int[H + 1];
        int min = N + 1;
        for (int i = 1; i <= H; i++) {
            arr[i] = prefix[i] + suffix[i];
            min = Math.min(min, arr[i]);
        }

        int answer = 0;
        for (int i = 1; i <= H; i++) {
            if (arr[i] == min) {
                answer++;
            }
        }

        System.out.println(min + " " + answer);
    }
}