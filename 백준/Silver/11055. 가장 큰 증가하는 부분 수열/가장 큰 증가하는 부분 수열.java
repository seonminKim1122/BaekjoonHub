import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }


        int[] dp = new int[N];
        int result = dp[0] = sequence[0];
        for (int i = 1; i < N; i++) {
            dp[i] = sequence[i];
            for (int j = i - 1; j >= 0; j--) {
                if (sequence[j] < sequence[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + sequence[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}