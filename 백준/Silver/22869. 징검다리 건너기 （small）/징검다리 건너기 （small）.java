import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[N];

        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.add(0);

        String result = "NO";
        loop : while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == N - 1) {
                result = "YES";
                break;
            }

            for (int i = 1; i <= K; i++) {
                int to = now + i;

                if (to >= N) break;
                if (visited[to]) continue;

                int power = i * (1 + Math.abs(A[to] - A[now]));
                if (power <= K) {
                    visited[to] = true;
                    if (to == N - 1) {
                        result = "YES";
                        break loop;
                    }
                    queue.add(to);
                }
            }
        }

        System.out.println(result);
    }
}