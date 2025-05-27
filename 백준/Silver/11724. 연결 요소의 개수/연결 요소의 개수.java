import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수

        int[][] graph = new int[N][N];
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        boolean[] visit = new boolean[N];
        int answer = 0;
        for (int from = 0; from < N; from++) {
            if (visit[from]) continue;
            dfs(graph, N, from, visit);
            answer++;
        }

        System.out.println(answer);
    }

    private static void dfs(int[][] graph, int N, int from, boolean[] visit) {

        for (int to = 0; to < N; to++) {
            if (graph[from][to] == 0 || visit[to]) continue;

            visit[to] = true;
            dfs(graph, N, to, visit);
        }
    }
}