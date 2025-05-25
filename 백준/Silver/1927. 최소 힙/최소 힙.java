import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (N > 0) {
            N--;

            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                answer.append(pq.isEmpty() ? x : pq.poll()).append("\n");
            } else {
                pq.add(x);
            }
        }

        System.out.println(answer);
    }

}