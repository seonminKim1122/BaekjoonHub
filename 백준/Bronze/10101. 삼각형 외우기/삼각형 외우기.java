import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int angle1 = sc.nextInt();
        int angle2 = sc.nextInt();
        int angle3 = sc.nextInt();

        if (angle1 + angle2 + angle3 == 180) {
            if (angle1 == angle2 && angle2 == angle3) {
                System.out.println("Equilateral");
            } else if (angle1 != angle2 && angle2 != angle3 && angle3 != angle1) {
                System.out.println("Scalene");
            } else {
                System.out.println("Isosceles");
            }
        } else {
            System.out.println("Error");
        }
    }
}