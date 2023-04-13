import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a;
        int b;
        int c;

        while ((a=sc.nextInt()) + (b=sc.nextInt()) + (c=sc.nextInt()) != 0) {
            if (a + b + c <= 2 * Math.max(c,Math.max(a, b))) {
                System.out.println("Invalid");
            } else {
                if (a == b && b == c) {
                    System.out.println("Equilateral");
                } else if (a != b && b != c && c != a) {
                    System.out.println("Scalene");
                } else {
                    System.out.println("Isosceles");
                }
            }
        }
    }
}