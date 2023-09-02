import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            dfs(i, i, new boolean[N], graph, result);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int start, int from, boolean[] visited, int[][] graph, int[][] result) {
        for (int to = 0; to < visited.length; to++) {
            if (!visited[to] && graph[from][to] == 1) {
                visited[to] = true;
                result[start][to] = 1;
                dfs(start, to, visited, graph, result);
            }
        }
    }
}