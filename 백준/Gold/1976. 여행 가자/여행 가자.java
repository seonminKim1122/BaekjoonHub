import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int[] parent;

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int node1 = 1; node1 <= N; node1++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int node2 = 1; node2 <= N; node2++) {
                int connect = Integer.parseInt(st.nextToken());
                if (connect == 0) continue;
                union(node1, node2);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int p = find(node);
        for (int i = 1; i < M; i++) {
            int next = Integer.parseInt(st.nextToken());
            if (p != find(next)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    static void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 != root2) {
            parent[root2] = root1;
        }
    }

    static int find(int node) {
        if (parent[node] == node) {
            return node;
        }

        parent[node] = find(parent[node]);
        return parent[node];
    }
}