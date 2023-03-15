import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        int N = Integer.parseInt(s);
        int min = N - 9*(len-1) - (N/(int) Math.pow(10, len-1) - 1);

        int result = 0;
        for (int i = min; i < N; i++) {
            String num = String.valueOf(i);
            int decompositionSum = i;
            for (String n : num.split("")) {
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