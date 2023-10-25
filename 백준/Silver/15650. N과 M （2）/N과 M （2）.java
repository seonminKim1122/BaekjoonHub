import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, visited, 1);
            visited[i] = false;
        }
    }

    public static void dfs(int i, boolean[] visited, int depth) {
        if (depth == M) {
            print(visited);
            return;
        }

        for (int j = i + 1; j <= N; j++) {
            visited[j] = true;
            dfs(j, visited, depth + 1);
            visited[j] = false;
        }
    }

    public static void print(boolean[] visited) {
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}