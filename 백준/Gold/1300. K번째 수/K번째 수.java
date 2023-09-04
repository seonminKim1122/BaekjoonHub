import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long start = 1;
        long end = (long) N * N;

        while (start <= end) {
            long mid = (start + end) / 2;

            long cnt = 1;
            for (int i = 1; i <= N; i++) {
                if (mid % i != 0) {
                    cnt += Math.min(N, mid / i);
                } else {
                    cnt += Math.min(N, (mid / i) - 1);
                }
            }

            if (cnt <= k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}