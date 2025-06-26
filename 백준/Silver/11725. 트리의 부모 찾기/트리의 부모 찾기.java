import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        boolean[] visit = new boolean[N + 1];
        int[] parent = new int[N + 1];
        dfs(1, graph, visit, parent);

        StringBuilder answer = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            answer.append(parent[i]).append("\n");
        }

        System.out.println(answer);
    }

    static void dfs(int node, List<List<Integer>> graph, boolean[] visit, int[] parent) {
        visit[node] = true;

        for (int next: graph.get(node)) {
            if (visit[next]) continue;

            parent[next] = node;
            dfs(next, graph, visit, parent);
        }
    }
}