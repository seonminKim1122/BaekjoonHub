import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (!graph.containsKey(B)) {
                graph.put(B, new ArrayList<>());
            }

            graph.get(B).add(A);
        }

        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!graph.containsKey(i)) {
                dp[i] = 1;
            } else {
                List<Integer> befores = graph.get(i);
                int max = 0;
                for (int before : befores) {
                    max = Math.max(max, dp[before]);
                }
                dp[i] = max + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(dp[i]).append(" ");
        }

        System.out.println(sb);
    }
}