import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int INF = 10000 * 500;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while (TC > 0) {
            TC--;

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 지점의 수
            int M = Integer.parseInt(st.nextToken()); // 도로의 수
            int W = Integer.parseInt(st.nextToken()); // 웜홀의 수


            List<Map<Integer, Integer>> graph = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                graph.add(new HashMap<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(st.nextToken()) - 1;
                int E = Integer.parseInt(st.nextToken()) - 1;
                int T = Integer.parseInt(st.nextToken());

                Map<Integer, Integer> edges = graph.get(S);
                edges.put(E, Math.min(edges.getOrDefault(E, INF), T));

                edges = graph.get(E);
                edges.put(S, Math.min(edges.getOrDefault(S, INF), T));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(st.nextToken()) - 1;
                int E = Integer.parseInt(st.nextToken()) - 1;
                int T = Integer.parseInt(st.nextToken());

                Map<Integer, Integer> edges = graph.get(S);
                edges.put(E, Math.min(edges.getOrDefault(E, INF), -T));
            }

            // 연결요소가 여러 개일 수 있으므로 임의의 노드를 만들어 연결
            graph.add(new HashMap<>());
            for (int i = 0; i < N; i++) {
                graph.get(N).put(i, 0);
            }

            answer.append(solve(graph, N + 1)).append("\n");
        }

        System.out.println(answer);
    }

    static String solve(List<Map<Integer, Integer>> graph, int N) {

        int[] dist = new int[N];
        Arrays.fill(dist, INF);
        dist[N - 1] = 0;

        for (int i = 0; i < N - 1; i++) {

            for (int from = 0; from < N; from++) {
                Map<Integer, Integer> edges = graph.get(from);

                for (int to: edges.keySet()) {
                    dist[to] = Math.min(dist[to], dist[from] + edges.get(to));
                }
            }

        }

        for (int from = 0; from < N; from++) {
            Map<Integer, Integer> edges = graph.get(from);

            for (int to: edges.keySet()) {
                if (dist[to] > dist[from] + edges.get(to)) {
                    return "YES";
                }
            }
        }

        return "NO";
    }

}