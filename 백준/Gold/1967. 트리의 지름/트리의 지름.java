import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int INF = 20000 * 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, w));
            graph.get(b).add(new Edge(a, w));
        }

        if (n == 1) {
            System.out.println(0);
            return;
        }
        /*
        트리의 지름을 이루는 정점이 X, Y 라고 가정
        1) A가 X, Y 중 하나일 때 => 당연히 위 논리가 성립
        2) B가 X, Y 중 하나일 때 => 당연히 위 논리가 성립
        3) A 도 B 도 X, Y 가 아닐 때
           [1] A <-> B 를 잇는 경로가 X <-> Y 를 잇는 경로와 겹치는 정점(Z)이 있을 때
            - 지름: d(X, Z) + d(Z, Y)
            - A와 가장 멀리 떨어진 정점은 d(A, Z) + d(Z, [?]) 가 최대가 되어야 하는데
            - [?]가 B라는 말은 d(X, Z) 나 d(Z, Y) 보다 d(Z, B) 가 크다는 의미
            - 따라서 d(X, Z) + d(Z, Y) 가 지름이 될 수 없다
            - 즉, 최초 가정인 "A도 B도 X, Y가 아니다" 가 모순
            
            [2] A <-> B 를 잇는 경로가 x <-> Y 를 잇는 경로와 독립적일 때
            - 경로가 독립적이라는 말은 A <-> B, X <-> Y 를 잇는 또 다른 경로(Z <-> W)가 있다는 의미
            - d(Z, B) > d(Z, W) + d(W, X)
            - d(Z, B) > d(Z, W) + d(W, Y)
            - d(W, Y) > d(W, Z) + d(Z, A)
            - d(W, Y) > d(W, Z) + d(Z, B)
            - 위 4가지 조건을 모두 성립해야 하는데 2, 4번 조건을 서로 대입해보면 성립이 불가능함
            - 따라서 최초 가정인 "A도 B도 X, Y가 아니다" 가 모순

         결론
         "임의의 정정 A에서 가장 멀리 떨어진 정점 B는 반드시 트리의 지름을 이루는 정점일 수밖에 없다"
         => 따라서 B를 구하고 B에서 가장 멀리 떨어진 정점 C를 구하면 d(B, C) 가 트리의 지름
         */
        int[] B = findMostFarNode(1, graph, n);
        int[] C = findMostFarNode(B[0], graph, n);

        System.out.println(C[1]);
    }

    /**
     * @param from: 기준이 되는 정점
     * @param graph: 트리구조
     * @param n: 노드의 갯수
     * @return {from 과 가장 멀리 떨어진 정점, from 과 가장 멀리 떨어진 정점 사이의 거리}
     */
    static int[] findMostFarNode(int from, List<List<Edge>> graph, int n) {
        final int INF = 100 * 10000;

        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[0] = 0;
        dist[from] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> i1[1] - i2[1]);
        pq.add(new int[]{from, 0});

        boolean[] used = new boolean[n + 1];
        used[from] = true;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            used[now[0]] = true;

            List<Edge> edges = graph.get(now[0]);
            for (Edge edge: edges) {
                if (used[edge.to]) continue;

                if (dist[edge.to] > dist[now[0]] + edge.weight) {
                    dist[edge.to] = dist[now[0]] + edge.weight;
                    pq.add(new int[]{edge.to, dist[edge.to]});
                }
            }
        }

        int max = dist[0];
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > max) {
                max = dist[i];
                result = i;
            }
        }

        return new int[]{result, max};
    }


    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}