import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N + 1];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        visited[N] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int now = temp[0];
            int cnt = temp[1];

            if (now == 1) {
                System.out.println(cnt);
                break;
            }

            if (now % 3 == 0 && !visited[now / 3]) {
                queue.add(new int[]{now / 3, cnt + 1});
                visited[now / 3] = true;
            }

            if (now % 2 == 0 && !visited[now / 2]) {
                queue.add(new int[]{now / 2, cnt + 1});
                visited[now / 2] = true;
            }

            if (!visited[now - 1]) {
                queue.add(new int[]{now - 1, cnt + 1});
                visited[now - 1] = true;
            }
        }
    }
}