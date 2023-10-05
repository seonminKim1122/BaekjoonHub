import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken()); // 늘리고자 하는 최소 고객 수
        int N = Integer.parseInt(st.nextToken()); // 홍보할 수 있는 도시의 개수

        int[][] cities = new int[N][2]; // 0 : 비용, 1 : 얻을 수 있는 고객
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                cities[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dp = new int[C + 1];
        for (int i = 1; i <= C; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                int idx = Math.max(0, i - cities[j][1]);
                dp[i] = Math.min(dp[i], dp[idx] + cities[j][0]);
            }
        }

        System.out.println(dp[C]);
    }
}