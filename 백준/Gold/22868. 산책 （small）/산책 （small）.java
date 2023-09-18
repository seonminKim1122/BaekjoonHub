import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Main {

    static int N;
    static int M;
    static boolean[] visited;
    static int result = 0;
    static int[] path;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        path = new int[N];

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A - 1).add(B - 1);
            graph.get(B - 1).add(A - 1);
        }

        for (int i = 0; i < N; i++) {
            Collections.sort(graph.get(i));
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()) - 1;
        int E = Integer.parseInt(st.nextToken()) - 1;

        bfs(S, E);

        visited = new boolean[N];

        int idx = E;
        while (idx != S) {
            visited[path[idx]] = true;
            idx = path[idx];
        }

        visited[S] = false;

        bfs(E, S);

        System.out.println(result);
    }

    public static void bfs(int start, int end) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int from = now[0];
            int distance = now[1];

            if (from == end) {
                result += distance;
                break;
            }

            List<Integer> toList = graph.get(from);
            for (int to : toList) {
                if (!visited[to]) {
                    queue.add(new int[]{to, distance + 1});
                    visited[to] = true;
                    path[to] = from;
                }
            }
        }
    }
}