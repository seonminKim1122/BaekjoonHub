import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

        dijkstra2(K);
        for (int i = 0; i < V; i++) {
            System.out.println(dist[i] == 200001 ? "INF" : dist[i]);
        }
    }

    public static void dijkstra2(int start) { // 우선순위 큐를 이용한 다익스트라
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        boolean[] visited = new boolean[V];

        priorityQueue.add(new Node(start, 0));
        visited[start] = true;
        dist[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node now = priorityQueue.poll();

            int from = now.to;

            for (Node node : graph[from]) {
                if (dist[node.to] > dist[from] + node.cost) {
                    dist[node.to] = dist[from] + node.cost;
                    priorityQueue.add(new Node(node.to, dist[node.to]));
                }
            }
        }
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