import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] t = new long[n + 1];
        t[0] = 1L;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                t[i] += t[j] * t[i - (j + 1)];
            }
        }

        System.out.println(t[n]);
    }
}