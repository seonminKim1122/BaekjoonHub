import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();

        if (M >= 45) {
            System.out.println(H + " " +(M-45));
        } else {
            H = (H-1) < 0 ? 23 : (H-1);
            System.out.println(H + " " +(M+15));
        }
    }
}