import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        StringBuilder answer = new StringBuilder();
        answer.append("<");
        int count = 0;
        while (!deque.isEmpty()) {
            int person = deque.pollFirst();
            count++;

            if (count == K) {
                answer.append(person);
                if (!deque.isEmpty()) {
                    answer.append(", ");
                }
                count = 0;
                continue;
            }

            deque.addLast(person);
        }
        answer.append(">");

        System.out.println(answer);
    }
}