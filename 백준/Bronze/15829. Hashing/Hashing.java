import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double r = 31;

        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        char[] chars = s.toCharArray();
        long sum = 0;
        for (int i = 0; i < L; i++) {
            int num = (chars[i] - 'a') + 1;
            sum += num * Math.pow(r, i);
        }
        System.out.println(sum);
    }
}