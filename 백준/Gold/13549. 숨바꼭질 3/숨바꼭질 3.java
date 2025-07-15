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

        System.out.println(solve(N, K));
    }

    static int solve(int N, int K) {

        int[] times = new int[100001];
        Arrays.fill(times, 100001);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        times[N] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            // X - 1
            int next = now[0] - 1;
            if (isValid(next) && times[next] > now[1] + 1) {
                queue.add(new int[]{next, now[1] + 1});
                times[next] = now[1] + 1;
            }

            // X + 1
            next = now[0] + 1;
            if (isValid(next) && times[next] > now[1] + 1) {
                queue.add(new int[]{next, now[1] + 1});
                times[next] = now[1] + 1;
            }

            // 2 * X
            next = 2 * now[0];
            if (isValid(next) && times[next] > now[1]) {
                queue.add(new int[]{next, now[1]});
                times[next] = now[1];
            }
        }

        return times[K];
    }

    static boolean isValid(int index) {
        return index >= 0 && index <= 100000;
    }
}