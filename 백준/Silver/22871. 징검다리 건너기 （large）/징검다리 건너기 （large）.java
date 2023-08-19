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

        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        long[] dp = new long[N];
        dp[1] = 1 + Math.abs(A[1] - A[0]);

        for (int i = 2; i < N; i++) {
            dp[i] = i * (1 + Math.abs(A[i] - A[0]));
            for (int j = 1; j < i; j++) {
                dp[i] = Math.min(dp[i], Math.max(dp[j], (i-j) * (1 + Math.abs(A[i] - A[j]))));
            }
        }

        System.out.println(dp[N-1]);
    }
}