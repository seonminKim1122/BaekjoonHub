import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(calculator(N));
    }

    public static int calculator(int weight) {
        int result = 0;
        int fiveKg = weight / 5;
        int remain;
        for(int i = fiveKg; i >= 0; i--) {
            remain = weight - (5 * i);
            if(remain % 3 == 0) {
                result = i + (remain / 3);
                return result;
            }
        }
        return -1;
    }
}