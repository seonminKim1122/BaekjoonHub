import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> {
            if (Math.abs(i1) == Math.abs(i2)) {
                return i1 - i2;
            } else {
                return Math.abs(i1) - Math.abs(i2);
            }
        });

        int N = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while (N > 0) {
            N--;

            int x = Integer.parseInt(br.readLine());

            if (x != 0) {
                pq.add(x);
            } else {
                if (pq.isEmpty()) {
                    answer.append(0);
                } else {
                    answer.append(pq.poll());
                }
                answer.append("\n");
            }
        }

        System.out.println(answer);
    }

}