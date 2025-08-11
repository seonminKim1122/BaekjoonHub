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

        int[] times = new int[100001];
        Arrays.fill(times, 100000);
        times[N] = 0;
        int[] ways = new int[100001];
        ways[N] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while (!queue.isEmpty()) {
            int X = queue.poll();

            if (X == K) {
                break;
            }

            // X - 1
            if (X - 1 >= 0) {
                if (times[X - 1] > times[X] + 1) {
                    times[X - 1] = times[X] + 1;
                    ways[X - 1] = 1;
                    queue.add(X - 1);
                } else if (times[X - 1] == times[X] + 1) {
                    ways[X - 1] += 1;
                    queue.add(X - 1);
                }
            }

            // X + 1;
            if (X + 1 <= 100000) {
                if (times[X + 1] > times[X] + 1) {
                    times[X + 1] = times[X] + 1;
                    ways[X + 1] = 1;
                    queue.add(X + 1);
                } else if (times[X + 1] == times[X] + 1) {
                    ways[X + 1] += 1;
                    queue.add(X + 1);
                }
            }

            // 2 * X
            if (2 * X <= 100000) {
                if (times[2 * X] > times[X] + 1) {
                    times[2 * X] = times[X] + 1;
                    ways[2 * X] = 1;
                    queue.add(2 * X);
                } else if (times[2 * X] == times[X] + 1) {
                    ways[2 * X] += 1;
                    queue.add(2 * X);
                }
            }
        }

        System.out.println(times[K]);
        System.out.println(ways[K]);
    }
}