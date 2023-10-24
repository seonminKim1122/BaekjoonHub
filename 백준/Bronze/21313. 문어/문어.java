import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                result.append(1);
            } else {
                result.append(2);
            }
            result.append(" ");
        }

        if (result.charAt(0) == result.charAt(result.length() - 2)) {
            result.setCharAt(result.length() - 2, '3');
        }
        System.out.println(result);
    }
}