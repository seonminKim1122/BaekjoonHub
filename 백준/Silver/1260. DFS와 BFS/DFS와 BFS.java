import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1][v2] = graph[v2][v1] = 1;
        }

        boolean[] visit = new boolean[N + 1];
        dfs(V, graph, visit, N);
        answer.append("\n");
        bfs(V, graph, N);

        System.out.println(answer);
    }

    private static void dfs(int from, int[][] graph, boolean[] visit, int N) {
        visit[from] = true;
        answer.append(from).append(" ");

        for (int to = 1; to <= N; to++) {
            if (visit[to] || graph[from][to] != 1) continue;
            dfs(to, graph, visit, N);
        }
    }

    private static void bfs(int start, int[][] graph, int N) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];
        queue.add(start);
        visit[start] = true;
        answer.append(start);

        while (!queue.isEmpty()) {
            int from = queue.poll();

            for (int to = 1; to <= N; to++) {
                if (visit[to] || graph[from][to] != 1) continue;

                queue.add(to);
                visit[to] = true;
                answer.append(" ").append(to);
            }
        }
    }
}