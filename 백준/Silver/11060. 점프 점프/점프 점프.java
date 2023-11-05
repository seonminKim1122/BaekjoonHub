import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1000);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j <= i + A[i] ; j++) {
                if (j >= N) break;
                dp[j] = Math.min(dp[i] + 1, dp[j]);
            }
        }

        System.out.println(dp[N - 1] == 1000 ? -1 : dp[N - 1]);
    }
}