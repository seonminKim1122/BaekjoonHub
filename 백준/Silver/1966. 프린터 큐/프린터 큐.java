import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            Queue<Integer> queue = new LinkedList<>();

            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st2.nextToken());
                queue.add(num);
            }

            int targetIdx = M;
            int result = 0;
            while (true) {
                int max = queue.stream().max((num1, num2) -> num1 - num2).orElseThrow(IllegalArgumentException::new);
                while (queue.peek() != max) {
                    queue.add(queue.poll());
                    targetIdx = targetIdx - 1 >= 0 ? targetIdx - 1 : queue.size()-1;
                }
                queue.poll();
                targetIdx--;
                result++;
                if (targetIdx == -1) {
                    break;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}