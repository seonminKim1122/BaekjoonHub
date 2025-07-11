import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int INF = 100000 * 999;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 1 <= N <= 1000    : 도시의 개수
        int M = Integer.parseInt(br.readLine()); // 1 <= M <= 100000  : 버스의 개수

        int[][] cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(cost[i], INF);
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            cost[from][to] = Math.min(cost[from][to], c);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int from = Integer.parseInt(st.nextToken()) - 1;
        int to = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(solve(from, to, cost, N));
    }

    static int solve(int from, int to, int[][] cost, int N) {
        
        int[] dist = new int[N]; // from 에서 to 까지의 비용 dist[to]
        boolean[] used = new boolean[N];
        Arrays.fill(dist, INF);
        dist[from] = 0;

        for (int i = 0; i < N; i++) {
            // 최소비용인 노드 찾기
            int min = INF;
            int node = -1;
            for (int k = 0; k < N; k++) {
                if (used[k]) continue;
                if (dist[k] < min) {
                    node = k;
                    min = dist[k];
                }
            }

            if (node == -1) break;

            used[node] = true;
            // 찾은 노드에서 갈 수 있는 곳 갱신
            for (int next = 0; next < N; next++) {
                if (cost[node][next] == INF) continue;

                if (dist[node] + cost[node][next] < dist[next]) {
                    dist[next] = dist[node] + cost[node][next];
                }
            }
        }

        return dist[to];
    }
}