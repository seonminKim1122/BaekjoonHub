import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int result;
        if (x > 0) {
            result = y > 0 ? 1 : 4;
        } else {
            result = y > 0 ? 2 : 3;
        }
        System.out.println(result);
    }
}