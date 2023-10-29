import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Node>[] graph;
    static int[] dist;
    static boolean[] visited;

    static int V;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수
        K = Integer.parseInt(br.readLine()) - 1; // 시작 정점

        graph = new List[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, cost));
        }

        dist = new int[V];
        visited = new boolean[V];
        Arrays.fill(dist, 200001);
        dist[K] = 0;

        dijkstra(K);

        for (int i = 0; i < V; i++) {
            System.out.println(dist[i] == 200001 ? "INF" : dist[i]);
        }
    }

    public static void dijkstra(int from) {
        visited[from] = true;

        List<Node> nodes = graph[from];
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            dist[node.to] = Math.min(dist[node.to], dist[from] + node.cost);
        }

        int next = -1;
        int min = 200001;
        for (int i = 0; i < V; i++) {
            if (!visited[i] && dist[i] < min) {
                next = i;
                min = dist[i];
            }
        }

        if (next == -1) return;
        dijkstra(next);
    }
}

class Node {

    int to;
    int cost;

    Node (int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}