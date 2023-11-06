import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int K = Integer.parseInt(st.nextToken()); // 거리 정보
        int X = Integer.parseInt(st.nextToken()) - 1; // 출발 도시 번호

        List<Integer>[] roads = new List[N];
        for (int i = 0; i < N; i++) {
            roads[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            roads[from].add(to);
        }

        System.out.println(dijkstra(X, roads, K));
    }

    public static StringBuilder dijkstra(int X, List<Integer>[] roads, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(X);

        int N = roads.length;
        int[] dist = new int[N];
        Arrays.fill(dist, N);
        dist[X] = 0;

        while (!priorityQueue.isEmpty()) {
            int from = priorityQueue.poll();

            for (int to : roads[from]) {
                if (dist[to] > dist[from] + 1) {
                    dist[to] = dist[from] + 1;
                    priorityQueue.add(to);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (dist[i] == K) sb.append(i + 1).append("\n");
        }
        sb.setLength(Math.max(sb.length() - 1, 0));
        if (sb.length() == 0) sb.append(-1);

        return sb;
    }
}