import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        int greatestCommonFactor = getGreatestCommonFactor(A, B);
        int leastCommonMultiple = getLeastCommonMultiple(A, B);

        System.out.println(greatestCommonFactor);
        System.out.println(leastCommonMultiple);
    }

    public static int getGreatestCommonFactor(int x, int y) {
        if (x % y == 0) return y;
        return getGreatestCommonFactor(y, x % y);
    }

    public static int getLeastCommonMultiple(int x, int y) {
        return x * (y / getGreatestCommonFactor(x, y));
    }
}