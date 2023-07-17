import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");

            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            Queue<Integer> queue = new LinkedList<>();
            String[] importances = br.readLine().split(" ");
            for (String importance : importances) {
                queue.add(Integer.parseInt(importance));
            }


            int targetIdx = M;
            int result = 0;

            int max = getMax(queue);
            while (true) {
                if (queue.peek() != max) {
                    queue.add(queue.poll());
                } else {
                    queue.poll();
                    result++;
                    if (targetIdx == 0) {
                        sb.append(result).append("\n");
                        break;
                    }
                    max = getMax(queue);
                }
                targetIdx = (targetIdx - 1) < 0 ? queue.size() - 1 : targetIdx - 1;
            }
        }

        System.out.println(sb);
    }

    public static int getMax(Queue<Integer> queue) {
        int max = 0;

        for (int number : queue) {
            if (max < number) {
                max = number;
            }
        }

        return max;
    }
}