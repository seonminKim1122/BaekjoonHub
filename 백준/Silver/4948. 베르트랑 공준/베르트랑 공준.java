import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n == 0){break;}
            int result = 0;
            for(int i = n + 1; i <= 2 * n; i++) {
                result += test(i);
            }
            System.out.println(result);
        }
    }

    public static int test(int input) {
        if (input == 2) {
            return 1;
        }
        for (int i = 2; i <= Math.sqrt(input); i++) {
            if(input % i == 0) {
                return 0;
            }
        }
        return 1;
    }
}