import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> ladders = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            ladders.put(from, to);
        }

        Map<Integer, Integer> snakes = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            snakes.put(from, to);
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];
        queue.add(new int[]{1, 0});
        visited[1] = true;

        int result = 0;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int now = temp[0];
            int cnt = temp[1];

            if (now == 100) {
                result = cnt;
                break;
            }

            for (int i = 1; i <= 6; i++) {
                int next = now + i;

                if (next > 100 || visited[next]) continue;

                visited[next] = true;
                if (ladders.containsKey(next)) {
                    next = ladders.get(next);
                    visited[next] = true;
                    queue.add(new int[]{next, cnt + 1});
                } else if (snakes.containsKey(next)) {
                    next = snakes.get(next);
                    visited[next] = true;
                    queue.add(new int[]{next, cnt + 1});
                } else {
                    queue.add(new int[]{next, cnt + 1});
                }
            }

        }

        System.out.println(result);
    }
}