import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int sum = 0;
        int min = 0;
        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                sum += i;
                if (min == 0) {
                    min = i;
                }
            }
        }
        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }

    public static boolean isPrime(int n) {
        double sqrt = Math.sqrt(n);
        int cnt = 0;

        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                cnt++;
                break;
            }
        }

        if (cnt == 0 && n > 1) {
            return true;
        } else {
            return false;
        }
    }
}