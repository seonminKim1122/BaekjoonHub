import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int INF = 200_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] distance = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            distance[a][b] = distance[b][a] = c;
        }

        st = new StringTokenizer(br.readLine());

        int node1 = Integer.parseInt(st.nextToken()) - 1;
        int node2 = Integer.parseInt(st.nextToken()) - 1;

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = (distance[i][k] + distance[k][j]);
                    }
                }
            }
        }

        int temp1 = distance[0][node1] + distance[node1][node2] + distance[node2][N - 1];
        int temp2 = distance[0][node2] + distance[node2][node1] + distance[node1][N - 1];

        int result = Math.min(temp1, temp2);

        System.out.println(result >= INF ? -1 : result);
    }
}