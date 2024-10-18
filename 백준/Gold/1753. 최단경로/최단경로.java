import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine()) - 1;

        List<List<Node>> graph = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            graph.add(new ArrayList<>());
        }

        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        int[] result = dijkstra(graph, K);
        for (int i = 0; i < result.length; i++) {
            if (result[i] >= INF) {
                System.out.println("INF");
            } else {
                System.out.println(result[i]);
            }
        }
    }

    static int[] dijkstra(List<List<Node>> graph, int K) {
        int[] dist = new int[graph.size()];
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> dist[n1.vertex] - dist[n2.vertex]);

        Arrays.fill(dist, INF);
        dist[K] = 0;
        pq.add(new Node(K, 0)); // 시작 정점

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (Node node : graph.get(cur.vertex)) {
                if (dist[node.vertex] > dist[cur.vertex] + node.weight) {
                    dist[node.vertex] = dist[cur.vertex] + node.weight;
                    pq.add(node);
                }
            }
        }

        return dist;
    }

    static class Node {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}
