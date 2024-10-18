import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken()) - 1; // 시작 도시
            int B = Integer.parseInt(st.nextToken()) - 1; // 도착 도시
            int C = Integer.parseInt(st.nextToken()); // 소요 시간

            edges.add(new Edge(A, B, C));
        }

        long[] result = bellmanFord(edges, 0, N);
        if (result == null) {
            System.out.println(-1);
        } else{
            for (int i = 1; i < N; i++) {
                if (result[i] >= INF) {
                    System.out.println(-1);
                } else {
                    System.out.println(result[i]);
                }
            }
        }
    }

    static long[] bellmanFord(List<Edge> edges, int start, int V) {
        long[] dist = new long[V];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        for (int v = 0; v < V - 1; v++) {
            for (Edge edge : edges) {
                if (dist[edge.from] >= INF) continue;
                if (dist[edge.to] > dist[edge.from] + edge.weight) {
                    dist[edge.to] = dist[edge.from] + edge.weight;
                }
            }
        }
        
        // 마지막 1번 했을 때 음수 사이클 있는지 판단
        for (Edge edge : edges) {
            if (dist[edge.from] >= INF) continue;
            if (dist[edge.to] > dist[edge.from] + edge.weight) {
                return null;
            }
        }

        return dist;
    }

    static class Edge {
        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

}
