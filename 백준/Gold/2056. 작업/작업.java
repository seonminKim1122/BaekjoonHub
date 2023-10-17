import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        int result = 0;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            int cntOfBefore = Integer.parseInt(st.nextToken());


            for (int j = 0; j < cntOfBefore; j++) {
                int before = Integer.parseInt(st.nextToken());
                dp[i] = Math.max(dp[i], dp[before]);
            }

            dp[i] += time;
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}