import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();

        int n;
        if((v-a)%(a-b) != 0) {
            n = (v-a)/(a-b) + 2;
        } else {
            n = (v-a)/(a-b) + 1;
        }
        System.out.println(n);
    }
}