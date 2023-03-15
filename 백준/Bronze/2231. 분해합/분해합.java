import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int len = String.valueOf(N).length();
        int min = N - 9*(len-1) - N/(int)Math.pow(10, len-1);

        int result = 0;
        for (int i = min; i < N; i++) {
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