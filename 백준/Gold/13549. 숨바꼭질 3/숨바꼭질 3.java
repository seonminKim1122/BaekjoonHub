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


        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        queue.add(new int[]{N, 0});
        visited[N] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int X = curr[0];
            int time = curr[1];

            if (X == K) {
                System.out.println(time);
                return;
            }

            int temp = X;
            while (2 * temp <= 100000 && !visited[2 * temp]) {
                queue.add(new int[]{2 * temp, time});
                visited[2 * temp] = true;
                temp = 2 * temp;
            }

            if (X - 1 >= 0 && !visited[X - 1]) {
                queue.add(new int[]{X - 1, time + 1});
                visited[X - 1] = true;
            }

            if (X + 1 <= 100000 && !visited[X + 1]) {
                queue.add(new int[]{X + 1, time + 1});
                visited[X + 1] = true;
            }
        }
    }
}