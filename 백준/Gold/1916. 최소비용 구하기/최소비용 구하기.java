import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 도시의 개수
        int M = Integer.parseInt(br.readLine()); // 버스의 개수

        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            graph[from][to] = Math.min(graph[from][to], cost);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        int[] distance = new int[N];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        boolean[] visited = new boolean[N];

        for (int k = 0; k < N; k++) {
            int min = 100000001;
            int mid = -1;

            for (int i = 0; i < N; i++) {
                if (!visited[i] && distance[i] < min) {
                    min = distance[i];
                    mid = i;
                }
            }
            
            if (mid == -1) break;
            
            visited[mid] = true;
            for (int to = 0; to < N; to++) {
                if (distance[to] > distance[mid] + graph[mid][to]) {
                    distance[to] = distance[mid] + graph[mid][to];
                }
            }
        }

        System.out.println(distance[end]);
    }
}