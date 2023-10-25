import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int len = input.length();

        int district0 = 0;
        int district1 = 0;
        for (int i = 1; i < len; i++) {
            if (input.charAt(i) != input.charAt(i - 1)) {
                if (input.charAt(i - 1) == '0') {
                    district0++;
                } else {
                    district1++;
                }
            }
        }

        if (input.charAt(len - 1) == '0') {
            district0++;
        } else {
            district1++;
        }

        System.out.println(Math.min(district0, district1));
    }
}