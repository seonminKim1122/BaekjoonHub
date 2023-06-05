import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(temp.nextToken());
        int M = Integer.parseInt(temp.nextToken());

        boolean[][] graph = new boolean[N+1][N+1];
        boolean[] visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node1][node2] = true;
            graph[node2][node1] = true;
        }

        int result = 0;
        for (int i = 1; i < N+1; i++) {
            if (!visited[i]) {
                dfs(i, visited, graph);
                result++;
            }
        }
        System.out.println(result);
    }

    public static void dfs(int from, boolean[] visited, boolean[][] map) {
        visited[from] = true;
        int len = visited.length;

        for (int i = 1; i < len; i++) {
            if (map[from][i] && !visited[i]) {
                dfs(i, visited, map);
            }
        }
    }
}