import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String num = br.readLine();
            if (num.equals("0")) {
                break;
            }

            int[] numbers = Arrays.stream(num.split("")).mapToInt(Integer::parseInt).toArray();

            int size = numbers.length;
            int mid = size / 2;
            boolean yes = true;
            for (int i = 0; i < mid; i++) {
                if (numbers[i] != numbers[size - 1 - i]) {
                    yes = false;
                    break;
                }
            }

            if (yes) {
                sb.append("yes");
            } else {
                sb.append("no");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}