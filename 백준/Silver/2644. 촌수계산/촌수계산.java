import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int target1;
    static int target2;

    static int[][] graph;
    static boolean[][] visited;

    static int n;

    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        target1 = Integer.parseInt(st.nextToken()) - 1;
        target2 = Integer.parseInt(st.nextToken()) - 1;

        int m = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        visited = new boolean[n][n];
        dfs(target1, 0);

        System.out.println(result);
    }

    public static void dfs(int i, int depth) {
        if (i == target2) {
            result = depth;
            return;
        }

        for (int k = 0; k < n; k++) {
            if (graph[i][k] == 1 && !visited[i][k]) {
                visited[i][k] = true;
                visited[k][i] = true;

                dfs(k, depth + 1);
            }
        }
    }
}