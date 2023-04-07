import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int x = 1;
        int k = 0;
        if (N != 1) {
            /*
            1 < 2 => x = 1 + 6
            7 < 2 =>
             */
            while (x < N) {
                k++;
                x += 6*k;
            }
        }
        System.out.println(k+1);
    }
}