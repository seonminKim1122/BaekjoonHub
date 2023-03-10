import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        for (int i = M; i <= N; i++) {
            if(isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int num) {
        // 예외 처리
        if (num == 1) {
            return false;
        }

        if (num == 2) {
            return true;
        }
        
        // 소수인지 판별
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}