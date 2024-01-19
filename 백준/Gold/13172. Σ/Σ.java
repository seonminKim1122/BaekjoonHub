import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        long answer = 0;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long N = Integer.parseInt(st.nextToken());
            long S = Integer.parseInt(st.nextToken());

            long gcd = GCD(N, S);

            N /= gcd;
            S /= gcd;

            answer += S * modularReverse(N, MOD - 2);
            answer %= MOD;
        }
        System.out.println(answer);
    }

    public static long GCD(long A, long B) {
        if (B == 0) return A;
        return GCD(B, A % B);
    }

    public static long modularReverse(long b, int X) {
        if (X == 1) return b;
        long temp = modularReverse(b, X / 2);
        if (X % 2 == 1) {
            return temp * temp % MOD * b % MOD;
        } else {
            return temp * temp % MOD;
        }
    }
}