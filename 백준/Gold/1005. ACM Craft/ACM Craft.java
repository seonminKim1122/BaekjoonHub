import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] times;
    static List<Integer>[] graph;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 건물의 개수
            int K = Integer.parseInt(st.nextToken()); // 건설 규칙의 개수

            times = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                times[j] = Integer.parseInt(st.nextToken());
            }

            graph = new List[N + 1];
            for (int j = 1; j <= N; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());

                int before = Integer.parseInt(st.nextToken());
                int after = Integer.parseInt(st.nextToken());

                graph[after].add(before);
            }

            int W = Integer.parseInt(br.readLine());
            dp = new int[N + 1];
            Arrays.fill(dp, -1);
            result.append(dp(W)).append("\n");
        }

        System.out.println(result);
    }

    public static int dp(int job) {
        if (graph[job].size() == 0) {
            dp[job] = times[job];
        }

        if (dp[job] != -1) return dp[job];

        for (int before : graph[job]) {
            dp[job] = Math.max(dp[job], dp(before) + times[job]);
        }

        return dp[job];
    }
}