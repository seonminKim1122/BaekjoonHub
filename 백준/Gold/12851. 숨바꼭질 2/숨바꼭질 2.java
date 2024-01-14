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

        Queue<Integer> queue = new LinkedList<>();
        int[] visitedTime = new int[100001];
        Arrays.fill(visitedTime, 100000);

        queue.add(N);
        visitedTime[N] = 0;

        int result = 0;
        while (!queue.isEmpty()) {
            int now = queue.remove();
            if (visitedTime[now] > visitedTime[K]) continue;

            if (now == K) {
                result += 1;
                continue;
            }

            if (now - 1 >= 0 && visitedTime[now - 1] >= visitedTime[now] + 1) {
                queue.add(now - 1);
                visitedTime[now - 1] = visitedTime[now] + 1;
            }

            if (now + 1 <= 100000 && visitedTime[now + 1] >= visitedTime[now] + 1) {
                queue.add(now + 1);
                visitedTime[now + 1] = visitedTime[now] + 1;
            }

            if (2 * now <= 100000 && visitedTime[2 * now] >= visitedTime[now] + 1) {
                queue.add(2 * now);
                visitedTime[2 * now] = visitedTime[now] + 1;
            }
        }

        System.out.println(visitedTime[K]);
        System.out.println(result);
    }
}