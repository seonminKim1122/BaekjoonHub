import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins[(N-1)-i] = coin;
        }

        int result = 0;
        int i = 0;
        while (K > 0) {
            int coin = coins[i++];
            int cnt = K / coin;
            result += cnt;
            K -= coin * (cnt);
        }

        System.out.println(result);
    }
}