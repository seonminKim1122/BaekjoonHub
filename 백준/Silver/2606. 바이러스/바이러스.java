import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());

        int[][] graph = new int[N][N];
        boolean[] infected = new boolean[N];
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            graph[Integer.parseInt(input[0])-1][Integer.parseInt(input[1])-1] = 1;
            graph[Integer.parseInt(input[1])-1][Integer.parseInt(input[0])-1] = 1;
        }

        infected[0] = true;
        dfs(graph, infected, 0);

        int result = 0;
        for (int i = 1; i < N; i++) {
            if (infected[i]) result++;
        }

        System.out.println(result);
    }

    public static void dfs(int[][] graph, boolean[] infected, int from) {
        infected[from] = true;

        for (int i = 0; i < infected.length; i++) {
            if (graph[from][i] == 1 && !infected[i]) {
                dfs(graph, infected, i);
            }
        }
    }
}