import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] weights = new int[N + 1];
        int V = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            V += weights[i];
        }

        boolean[][] dp = new boolean[N + 1][V + 1];
        dp[0][0] = true;

        for (int i = 1; i <= N; i++) {
            int weight = weights[i];

            for (int j = 0; j <= V - weight; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = dp[i - 1][j];
                    dp[i][j + weight] = true;
                    dp[i][Math.abs(j - weight)] = true;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            if (target <= V && dp[N][target]) {
                result.append("Y");
            } else {
                result.append("N");
            }
            result.append(" ");
        }

        System.out.println(result);
    }
}