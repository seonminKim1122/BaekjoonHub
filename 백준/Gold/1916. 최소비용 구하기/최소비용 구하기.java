import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 도시의 개수
        int M = Integer.parseInt(br.readLine()); // 버스의 개수

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i < N; i++) {
            int mid = -1;
            int min = INF;

            for (int j = 1; j <= N; j++) {
                if (!visited[j] && dist[j] < min) {
                    mid = j;
                    min = dist[j];
                }
            }

            if (mid == -1) break;
            
            visited[mid] = true;
            for (Node node : graph.get(mid)) {
                if (dist[node.to] > dist[mid] + node.cost) {
                    dist[node.to] = dist[mid] + node.cost;
                }
            }
        }

        System.out.println(dist[end]);
    }

    private static class Node {
        int to;
        int cost;

        Node (int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}