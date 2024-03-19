import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 추 정보
        int N = Integer.parseInt(br.readLine()); // 추의 개수
        int[] weights = new int[N];
        int totalWeight = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            totalWeight += weights[i];
        }
        // 추를 이용해 측정 되는지 확인하고자 하는 타겟 무게 정보
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] targets = new int[M];
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        // 로직
        boolean[][] dp = new boolean[N + 1][totalWeight + 1];
        dp[0][0] = true;

        for (int i = 1; i <= N; i++) {
            int weight = weights[i - 1];
            for (int j = 0; j <= totalWeight; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                    dp[i][j + weight] = true;
                    dp[i][Math.abs(j - weight)] = true;
                }
            }
        }

        for (int target : targets) {
            if (target > totalWeight) {
                System.out.print("N ");
            } else {
                System.out.print(dp[N][target] ? "Y " : "N ");
            }
        }
    }
}
