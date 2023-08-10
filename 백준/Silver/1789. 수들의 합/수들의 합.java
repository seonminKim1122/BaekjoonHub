import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());

        long N = 1;
        while (N*(N+1) <= 2 * S) {
            N++;
        }

        System.out.println(N-1);
    }
}