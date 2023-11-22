import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new List[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            graph[from].add(to);
            graph[to].add(from);
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        queue.add(new int[]{a, 0});
        visited[a] = true;

        int result = -1;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            int num = temp[0];
            int cntOfChange = temp[1];

            if (num == b) {
                result = cntOfChange;
                break;
            }

            for (int next : graph[num]) {
                if (!visited[next]) {
                    queue.add(new int[]{next, cntOfChange + 1});
                    visited[next] = true;
                }
            }
        }

        System.out.println(result);
    }
}