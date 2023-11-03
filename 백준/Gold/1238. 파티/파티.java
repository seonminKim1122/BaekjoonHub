import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int X;

    static int[][] graph;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;

        graph = new int[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int time =Integer.parseInt(st.nextToken());

            graph[from][to] = time;
        }

        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], 100 * (N - 1) + 1); // 1 <= Ti <= 100;
        }

        for (int i = 0; i < N; i++) {
            dijkstra(i);
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dist[i][X] + dist[X][i]);
        }

        System.out.println(result);
    }

    public static void dijkstra(int start) {
        dist[start][start] = 0;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((i1, i2) -> i1[1] - i2[1]);
        priorityQueue.add(new int[]{start, dist[start][start]});


        while (!priorityQueue.isEmpty()) {
            int[] now = priorityQueue.poll();

            int from = now[0];
            int time = now[1];

            for (int i = 0; i < N; i++) {
                if (graph[from][i] != 0 && dist[start][i] > dist[start][from] + graph[from][i]) {
                    dist[start][i] = dist[start][from] + graph[from][i];
                    priorityQueue.add(new int[]{i, dist[start][i]});
                }
            }
        }
    }
}