import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Link>> links = new ArrayList<>();

    static int maxDist = 0;
    static int node = -1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());
        for (int i = 0; i < V; i++) {
            links.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken()) - 1;
            while (st.hasMoreTokens()) {
                int to = Integer.parseInt(st.nextToken()) - 1;
                if (to < 0) break;
                int cost = Integer.parseInt(st.nextToken());

                links.get(from).add(new Link(to, cost));
            }
        }

        dfs(0, new boolean[V + 1], 0);
        dfs(node, new boolean[V + 1], 0);

        System.out.println(maxDist);
    }

    public static void dfs(int from, boolean[] visited, int distance) {
        if (distance > maxDist) {
            maxDist = distance;
            node = from;
        }

        visited[from] = true;

        for (Link link : links.get(from)) {
            if (!visited[link.node]) {
                dfs(link.node, visited, distance + link.cost);
            }
        }


    }

    private static class Link {
        int node;
        int cost;

        Link (int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}