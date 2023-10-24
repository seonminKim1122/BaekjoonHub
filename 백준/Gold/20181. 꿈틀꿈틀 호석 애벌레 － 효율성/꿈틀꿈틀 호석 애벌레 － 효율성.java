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

        st = new StringTokenizer(br.readLine());
        int[] foods = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            foods[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        dp[1] = Math.max(0, foods[1] - K);

        for (int i = 2; i <= N; i++) {

            int sum = 0;
            int idx = i - 1;
            for (int j = i - 1; j >= 1; j--) {
                sum += foods[j];
                if (sum >= K) {
                    idx = j;
                    sum -= foods[j];
                    break;
                }
            }

            dp[i] = Math.max(dp[i - 1], dp[idx] + Math.max(0, sum + foods[i] - K));
        }

        System.out.println(dp[N]);
    }
}