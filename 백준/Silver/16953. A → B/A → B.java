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

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visit = new boolean[B + 1];
        queue.add(new int[]{B, 0});
        visit[B] = true;

        int answer = -1;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            int now = temp[0];
            if (now == A) {
                answer = temp[1] + 1;
                break;
            }

            int next = -1;
            if (now % 10 == 1) {
                next = now / 10;
            } else if (now % 2 == 0) {
                next = now / 2;
            }

            if (next != -1 && !visit[next]) {
                queue.add(new int[]{next, temp[1] + 1});
                visit[next] = true;
            }
        }

        System.out.println(answer);
    }

}