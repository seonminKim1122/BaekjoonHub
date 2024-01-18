import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        // Kruskal MST -> 간선 정보를 우선순위큐(비용기준)에 담고
        // 하나씩 빼면서 UNION 함수 적용해 이미 같은 그룹이면 지나가고 아니면 트리에 포함(cost 추가)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수

        // 간선 정보
        PriorityQueue<Link> links = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken()) - 1;
            int node2 = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            links.add(new Link(node1, node2, cost));
        }

        // 부모 노드 배열 초기화
        parent = new int[V];
        Arrays.fill(parent, -1);

        int result = 0; // 문제에서  -2,147,483,648 <= 최소 스패닝 트리 가중치 <= 2,147,483,647 보장
        int cnt = 0;

        while (cnt < V - 1) {
            if (links.isEmpty()) break;

            Link link = links.poll();
            if (UNION(link.node1, link.node2)) {
                result += link.cost;
                cnt++;
            }
        }

        System.out.println(result);
    }

    public static boolean UNION(int node1, int node2) {
        int root1 = FIND(node1);
        int root2 = FIND(node2);

        if (root1 == root2) return false;
        parent[root2] = root1;
        return true;
    }

    public static int FIND(int node) {
        if (parent[node] == -1) return node;
        return FIND(parent[node]);
    }

    static class Link implements Comparable<Link> {
        int node1;
        int node2;
        int cost;

        Link (int node1, int node2, int cost) {
            this.node1 = node1;
            this.node2 = node2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Link o) {
            return this.cost - o.cost;
        }
    }
}
