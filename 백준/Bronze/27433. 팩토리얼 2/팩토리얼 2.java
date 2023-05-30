import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(factorial(sc.nextLong()));
    }

    public static long factorial(long n) {
        if (n <= 1) {
            return 1;
        }

        return n * factorial(n-1);
    }
}