import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            sb.append(calculator(k)[n-1]).append("\n");
        }
        System.out.println(sb);
    }

    public static int[] calculator(int k) {
        int[] apartment = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        for (int i = 0; i < k; i++) {
            int num = apartment[0];
            for (int j = 1; j < 14; j++) {
                num += apartment[j];
                apartment[j] = num;
            }
        }
        return apartment;
    }
}