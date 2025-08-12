import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int DIV = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            long inverse = calcInverse(N);
            int Y = (int)(((S % DIV) * inverse) % DIV);
            result += Y;
            result %= DIV;
        }

        System.out.println(result);
    }

    static long calcInverse(int N) {
        return power(N, DIV - 2);
    }

    static long power(int N, int X) {
        if (X == 0) {
            return 1;
        }
        if (X == 1) {
            return N % DIV;
        }

        long temp = power(N, X / 2);
        if (X % 2 == 0) {
            return (temp * temp) % DIV;
        } else {
            return ((temp * temp) % DIV) * (N % DIV) % DIV;
        }
    }
}