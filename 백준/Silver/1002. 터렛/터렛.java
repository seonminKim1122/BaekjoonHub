import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            System.out.println(calc(x1, y1, r1, x2, y2, r2));
        }
    }

    public static int calc(int x1, int y1, int r1, int x2, int y2, int r2) {
        double d = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

        if ( d == 0 && r1 == r2) {
            return -1;
        } else if (d > r1 + r2 || d < Math.abs(r1 - r2)) {
            return 0;
        } else if (d == r1 + r2 || d == Math.abs(r1 - r2)) {
            return 1;
        } else {
            return 2;
        }
    }
}