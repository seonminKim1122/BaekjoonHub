import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int coin5 = n / 5;
        int coin2 = (n - (5 * coin5)) / 2;

        while (coin5 * 5 + coin2 * 2 != n) {
            if (coin5 < 0) {
                break;
            }
            coin5 -= 1;
            coin2 = (n - (5 * coin5)) / 2;
        }

        System.out.println(coin5 < 0 ? -1 : coin5 + coin2);

    }
}