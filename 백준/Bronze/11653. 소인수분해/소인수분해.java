import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int divisor = 2;
        while ((N / divisor) != 0) {
            if (N % divisor == 0) {
                N /= divisor;
                System.out.println(divisor);
                divisor = 2;
            } else {
                divisor++;
            }
        }
    }
}