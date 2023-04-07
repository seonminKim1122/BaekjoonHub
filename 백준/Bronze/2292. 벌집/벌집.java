import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int x = 0;
        if (N != 1) {
            while (3*(x)*(x+1) + 1 < N) {
                x++;
            }
        }
        System.out.println(x+1);
    }
}