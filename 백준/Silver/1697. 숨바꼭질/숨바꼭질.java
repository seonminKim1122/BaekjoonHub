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

        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[1000001];

        int result = 0;
        queue.add(new int[]{from, 0});
        visited[from] = true;

        while (true) {
            int[] temp = queue.poll();
            int now = temp[0];
            int sec = temp[1];
            if (now == to) {
                result = sec;
                break;
            }

            if (now < 50001 && !visited[2 * now]) {
                queue.add(new int[]{2 * now, sec + 1});
                visited[2 * now] = true;
            }

            if (now >= 1 && !visited[now - 1]) {
                queue.add(new int[]{now - 1, sec + 1});
                visited[now - 1] = true;
            }

            if (now < 100000 && !visited[now + 1]) {
                queue.add(new int[]{now + 1, sec + 1});
                visited[now + 1] = true;
            }

        }

        System.out.println(result);
    }
}