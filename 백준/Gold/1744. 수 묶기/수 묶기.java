import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> positive = new PriorityQueue<>((n1, n2) -> n2 - n1);
        PriorityQueue<Integer> nonPositive = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number > 0) {
                positive.add(number);
            } else{
                nonPositive.add(number);
            }
        }

        int result = 0;
        while (!positive.isEmpty()) {
            int now = positive.poll();

            if (positive.isEmpty()) {
                result += now;
                break;
            }

            int next = positive.peek();
            if (now * next > now) {
                result += (now * positive.poll());
            } else {
                result += now;
            }
        }

        while (!nonPositive.isEmpty()) {
            int now = nonPositive.poll();

            if (nonPositive.isEmpty()) {
                result += now;
                break;
            }

            int next = nonPositive.poll();
            result += (now * next);
        }

        System.out.println(result);
    }
}