import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] graph;
    static int INF = 1_000_000_001;
    static int[] distance;

    static HashMap<Integer, List<Integer>> routes = new HashMap<>();
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            graph[from][to] = Math.min(graph[from][to], cost);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < n; i++) {
            routes.put(i, new ArrayList<>());
            routes.get(i).add(start + 1);
        }

        dijkstra(start);

        StringBuilder answer = new StringBuilder();

        answer.append(distance[end]).append("\n");

        answer.append(routes.get(end).size()).append("\n");

        for (int i = 0; i < routes.get(end).size(); i++) {
            answer.append(routes.get(end).get(i)).append(" ");
        }

        System.out.println(answer);
    }

    public static void dijkstra(int start) {
        distance = new int[n];
        for (int j = 0; j < n; j++) {
            distance[j] = graph[start][j];
        }
        distance[start] = 0;

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            // 아직 방문하지 않은 노드 중 비용이 최소인 노드 찾기
            int cost = INF;
            int via = -1;

            for (int node = 0; node < n; node++) {
                if (!visited[node] && distance[node] <= cost) {
                    cost = distance[node];
                    via = node;
                }
            }
            
            // via : 아직 방문하지 않은 노드 중 비용이 최소인 노드
            visited[via] = true;
            // via 를 경유해서 갈 수 있는 노드들 중 갱신할 수 있는 건 갱신
            for (int to = 0; to < n; to++) {
                if (distance[to] >= distance[via] + graph[via][to]) {
                    distance[to] = distance[via] + graph[via][to];

                    List<Integer> newRoute = new ArrayList<>();
                    for (int v : routes.get(via)) {
                        newRoute.add(v);
                    }
                    newRoute.add(to + 1);

                    routes.put(to, newRoute);
                }
            }
        }
    }
}