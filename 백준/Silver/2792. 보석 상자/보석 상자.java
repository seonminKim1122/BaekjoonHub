import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 아이들의 수
        int M = Integer.parseInt(st.nextToken()); // 색상의 수

        int[] jewelries = new int[M];
        int max = 0;
        for (int i = 0; i < M; i++) {
            jewelries[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, jewelries[i]);
        }

        int start = 1;
        int end = max;

        while (start <= end) {
            int mid = (start + end) / 2;

            int cnt = 0;
            for (int i = 0; i < M; i++) {
                cnt += jewelries[i] / mid;
                if (jewelries[i] % mid != 0) cnt++;
            }

            if (cnt <= N) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}