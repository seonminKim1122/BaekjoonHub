import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int gcd = GCD(A, B);
        System.out.println(gcd);
        System.out.println((A / gcd) * (B / gcd) * gcd);
    }

    public static int GCD(int A, int B) {
        if (B == 0) return A;

        if (A < B) {
            return GCD(B, A);
        }

        return GCD(B, A % B);
    }
}