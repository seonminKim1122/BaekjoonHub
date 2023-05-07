import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        long Big;
        long Small;
        if (A < B) {
            Big = B;
            Small = A;
            long i = 1;
            while (Big % Small != 0) {
                Big = B * (i++);
            }
        } else {
            Big = A;
            Small = B;
            long i = 1;
            while (Big % Small != 0) {
                Big = A * (i++);
            }
        }

        System.out.println(Big);
    }
}