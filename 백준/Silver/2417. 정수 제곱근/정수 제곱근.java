import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        long start = 0;
        long end = 2_147_483_648L * 2L; // 2^32

        while (start <= end) {
            long mid = (start + end) / 2;
            double v = (double)mid * mid;
            if (v < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
}