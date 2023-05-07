import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            while (true) {
                if (isPrime(num)) {
                    sb.append(num).append("\n");
                    break;
                }
                num++;
            }
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);

    }

    public static boolean isPrime(long n) {
        if (n <= 1) return false;

        long sqrt = (long)Math.sqrt(n);
        for (long i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}