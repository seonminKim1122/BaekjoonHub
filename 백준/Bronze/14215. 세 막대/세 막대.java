import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int[] triangle = {a, b, c};
        Arrays.sort(triangle);

        if (triangle[0] + triangle[1] <= triangle[2]) {
            System.out.println(2 * (triangle[1] + triangle[0]) - 1);
        } else {
            System.out.println(triangle[0] + triangle[1] + triangle[2]);
        }
    }
}