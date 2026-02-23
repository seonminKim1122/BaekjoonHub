import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            T--;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());   // 4
            int b = Integer.parseInt(st.nextToken());   // 23

            while (true) {
                int x = b / a + (b % a == 0 ? 0 : 1);
                a = a * x - b;
                b = b * x;

                if (a == 0) {   // a/b = 1/x 일 떄
                    answer.append(x);
                    break;
                }

                int gcd = gcd(a, b);
                a = a / gcd;
                b = b / gcd;
            }

            answer.append("\n");
        }

        System.out.println(answer);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
