import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] flavors = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sourness = Integer.parseInt(st.nextToken());
            int bitterness = Integer.parseInt(st.nextToken());

            flavors[i][0] = sourness;
            flavors[i][1] = bitterness;
        }

        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, visited, flavors);
            visited[i] = false;
        }

        System.out.println(result);
    }

    public static void dfs(int i, boolean[] visited, int[][] flavors) {
        int temp = calculator(visited, flavors);
        if (result > temp) {
            result = temp;
        }

        for (int j = i+1; j < visited.length; j++) {
            visited[j] = true;
            dfs(j, visited, flavors);
            visited[j] = false;
        }
    }

    public static int calculator(boolean[] visited, int[][] flavors) {
        int sourness = 1;
        int bitterness = 0;

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                sourness *= flavors[i][0];
                bitterness += flavors[i][1];
            }
        }

        return Math.abs(sourness - bitterness);
    }
}