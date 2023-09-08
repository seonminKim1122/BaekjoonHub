import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.*;

public class Main {

    static int n;
    static List<int[]>[] tree;
    static int temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            tree[A].add(new int[]{B, V});
            tree[B].add(new int[]{A, V});
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            dfs(i, new boolean[n+1], 0);
            result = Math.max(result, temp);
        }

        System.out.println(result);
    }

    public static void dfs(int A, boolean[] visited, int diameter) {
        visited[A] = true;

        temp = Math.max(temp, diameter);
        List<int[]> links = tree[A];
        for (int[] link : links) {
            if (!visited[link[0]]) {
                dfs(link[0], visited, diameter + link[1]);
            }
        }
    }
}