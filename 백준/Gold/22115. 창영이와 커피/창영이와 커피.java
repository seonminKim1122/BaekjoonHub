import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coffee = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            coffee[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K + 1];
        Arrays.fill(dp, N + 1);
        dp[0] = 0;
        for (int c : coffee) {
            for (int i = K; i >= c; i--) {
                dp[i] = Math.min(dp[i], dp[i - c] + 1);
            }
        }

        System.out.println(dp[K] == N + 1 ? -1 : dp[K]);
    }
}
