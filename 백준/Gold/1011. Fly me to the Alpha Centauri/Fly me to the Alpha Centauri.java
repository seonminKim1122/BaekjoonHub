import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            System.out.println(calculator(x, y));
        }
    }

    public static int calculator(int x, int y) {
        int d = y - x;
        int a = (int) Math.ceil((Math.sqrt(d)));

        if ((a-1)*(a-1) < d && d <= a*(a-1)) {
            return 2 * a - 2;
        } else {
            return 2 * a - 1;
        }
    }
}