import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int INF = 20000 * 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수
        int K = Integer.parseInt(br.readLine());  // 시작 정점

        List<Map<Integer, Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new HashMap<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            Map<Integer, Integer> map = graph.get(u);
            if (map.containsKey(v)) {
                map.put(v, Math.min(map.get(v), w));
            } else {
                map.put(v, w);
            }
        }

        System.out.println(solve(graph, K, V));
    }


    static String solve(List<Map<Integer, Integer>> graph, int K, int V) {

        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[K] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> i1[1] - i2[1]);
        boolean[] used = new boolean[V + 1];
        pq.add(new int[]{K, 0});
        used[K] = true;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            used[now[0]] = true;

            Map<Integer, Integer> edgeMap = graph.get(now[0]);
            for (int to : edgeMap.keySet()) {
                if (used[to]) continue;

                if (dist[to] > dist[now[0]] + edgeMap.get(to)) {
                    dist[to] = dist[now[0]] + edgeMap.get(to);
                    pq.add(new int[]{to, dist[to]});
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                answer.append("INF");
            } else {
                answer.append(dist[i]);
            }
            answer.append("\n");
        }

        return answer.toString();
    }
}