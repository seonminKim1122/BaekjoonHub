import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder dfsSb = new StringBuilder();
    static StringBuilder bfsSb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N+1][N+1];
        boolean[] dfsVisited = new boolean[N+1];
        boolean[] bfsVisited = new boolean[N+1];
        for (int i = 1; i <= M; i++) {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(temp.nextToken());
            int to = Integer.parseInt(temp.nextToken());
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        dfs(graph, dfsVisited, V);
        System.out.println(dfsSb);

        bfs(graph, bfsVisited, V);
        System.out.println(bfsSb);
    }

    public static void dfs(int[][] graph, boolean[] visited, int from) {
        if (visited[from]) {
            return;
        }

        visited[from] = true;
        dfsSb.append(from).append(" ");
        for (int to = 1; to < graph[from].length; to++) {
            if (graph[from][to] == 1) {
                dfs(graph, visited, to);
            }
        }
    }

    public static void bfs(int[][] graph, boolean[] visited, int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);

        while (!queue.isEmpty()) {
            int from = queue.remove();
            if (!visited[from]) {
                visited[from] = true;
                bfsSb.append(from).append(" ");
                for (int to = 1; to < graph[from].length; to++) {
                    if (graph[from][to] == 1 && !visited[to]) {
                        queue.add(to);
                    }
                }
            }
        }
    }
}