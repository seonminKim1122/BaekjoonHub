import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 샘터 갯수
        int K = Integer.parseInt(st.nextToken()); // 지어야 하는 집의 갯수

        st = new StringTokenizer(br.readLine());
        HashSet<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int fountain = Integer.parseInt(st.nextToken());
            queue.add(new int[]{fountain, 0});
            visited.add(fountain);
        }

        long result = 0;
        int cnt = 0;
        int[] dx = {-1, 1};
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 2; i++) {
                int to = now[0] + dx[i];

                if (visited.contains(to)) continue;

                cnt++;
                result += now[1] + 1;

                if (cnt == K) {
                    System.out.println(result);
                    return;
                }

                queue.add(new int[]{to, now[1] + 1});
                visited.add(to);
            }
        }
    }
}