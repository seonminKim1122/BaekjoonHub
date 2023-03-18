import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int minute = (B+C) % 60;
        int hour = (A + (B+C) / 60) % 24;

        System.out.println(hour + " " + minute);
    }
}