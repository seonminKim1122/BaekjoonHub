import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BigInteger result = factorial(N);

        BigInteger div = new BigInteger("10");
        int cnt = 0;
        while (result.remainder(div).equals(new BigInteger("0"))) {
            cnt++;
            div = div.multiply(new BigInteger("10"));
        }
        System.out.println(cnt);
    }

    public static BigInteger factorial(int N) {
        if (N <= 1) {
            return new BigInteger("1");
        }
        return factorial(N-1).multiply(new BigInteger(String.valueOf(N)));
    }
}