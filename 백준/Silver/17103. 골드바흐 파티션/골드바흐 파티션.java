import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        boolean[] che = new boolean[1000001];
        int sqrt = (int)Math.sqrt(1000000);
        for (int i = 2; i <= sqrt; i++) {
            if (isPrime(i)) {
                int num = 2;
                while (i*num <= 1000000) {
                    che[i*num] = true;
                    num++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(countPartition(num, che)).append("\n");
        }
        System.out.println(sb);
    }

    public static boolean isPrime(int num) {
        int sqrt = (int)Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static int countPartition(int num, boolean[] che) {
        int half = num/2;
        int result = 0;
        for (int i = 2; i <= half; i++) {
            if (!che[i] && !che[num-i]) {
                result++;
            }
        }
        return result;
    }
}