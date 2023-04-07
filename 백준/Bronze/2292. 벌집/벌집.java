import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int x = 1;
        if (N == 1) {
            System.out.println(x);
        } else {
            while (true) {
                if (3*x*(x-1)+1 < N && N <= 3*x*(x+1)+1) {
                    break;
                }
                x++;
            }
            System.out.println(x+1);
        }
    }
}