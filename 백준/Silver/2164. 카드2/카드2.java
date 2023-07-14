import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            // 제일 위의 카드 버리기
            queue.poll();
            // 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮기기
            queue.add(queue.poll());
        }

        System.out.println(queue.peek());
    }
}