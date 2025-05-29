import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[100001];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        visit[N] = true;

        int answer = -1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == K) {
                answer = now[1];
                break;
            }

            // + 1
            if (now[0] + 1 <= 100000 && !visit[now[0] + 1]) {
                queue.add(new int[]{now[0] + 1, now[1] + 1});
                visit[now[0] + 1] = true;
            }

            // -1
            if (now[0] - 1 >= 0 && !visit[now[0] - 1]) {
                queue.add(new int[]{now[0] - 1, now[1] + 1});
                visit[now[0] - 1] = true;
            }

            // * 2
            if (2 * now[0] <= 100000 && !visit[2 * now[0]]) {
                queue.add(new int[]{2 * now[0], now[1] + 1});
                visit[2 * now[0]] = true;
            }
        }

        System.out.println(answer);
    }


}