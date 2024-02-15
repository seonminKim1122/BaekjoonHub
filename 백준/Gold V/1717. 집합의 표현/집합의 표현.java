import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        Arrays.fill(parent, -1);
        int m = Integer.parseInt(st.nextToken());

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (order == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    answer.append("YES");
                } else {
                    answer.append("NO");
                }
                answer.append("\n");
            }
        }

        System.out.println(answer);
    }

    public static void union(int a, int b) {
        int root1 = find(a);
        int root2 = find(b);

        if (root1 != root2) {
            parent[root2] = root1;
        }
    }

    public static int find(int a) {
        if (parent[a] == -1) return a;
        parent[a] = find(parent[a]);
        return parent[a];
    }
}