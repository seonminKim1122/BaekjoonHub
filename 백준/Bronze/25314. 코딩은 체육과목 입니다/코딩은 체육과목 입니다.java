import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i=i+4) {
            System.out.print("long ");
        }
        System.out.println("int");
    }
}