import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int newNumber = N;
        int cnt = 0;
        
        while(true) {
            int a = newNumber / 10;
            int b = newNumber % 10;
            int c = a + b;
            int d = c % 10;
            newNumber = 10 * b + d;
            cnt++;
            if (N == newNumber) {
                break;
            }
        }
        System.out.println(cnt);
    }
}