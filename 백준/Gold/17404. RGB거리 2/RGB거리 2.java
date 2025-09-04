import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int INF = 1000 * 1000 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][3];
        int r = calcMinByColor(dp, cost, 'R', N);
        dp = new int[N][3];
        int g = calcMinByColor(dp, cost, 'G', N);
        dp = new int[N][3];
        int b = calcMinByColor(dp, cost, 'B', N);

        int answer = Math.min(Math.min(r, g), b);
        System.out.println(answer);
    }

    static int calcMinByColor(int[][] dp, int[][] cost, char color, int N) {
        /*
        첫 집에 정해진 색을 그대로 이어갈 수 있도록 나머지는 INF 처리
         */
        if (color == 'R') {
            dp[0][0] = cost[0][0];
            dp[0][1] = INF;
            dp[0][2] = INF;
        } else if (color == 'G') {
            dp[0][1] = cost[0][1];
            dp[0][0] = INF;
            dp[0][2] = INF;
        } else {
            dp[0][2] = cost[0][2];
            dp[0][0] = INF;
            dp[0][1] = INF;
        }

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
        }

        if (color == 'R') {
            return Math.min(dp[N - 1][1], dp[N - 1][2]);
        } else if (color == 'G') {
            return Math.min(dp[N - 1][0], dp[N - 1][2]);
        } else {
            return Math.min(dp[N - 1][0], dp[N - 1][1]);
        }
    }
}