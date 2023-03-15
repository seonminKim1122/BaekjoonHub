import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int result = 0;
        for (int i = 1; i < N; i++) {
            String number = String.valueOf(i);

            int decompositionSum = i;
            for (String n : number.split("")) {
                decompositionSum += Integer.parseInt(n);
            }

            if (decompositionSum == N) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}