import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while (T > 0) {
            T--;

            char[] p = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            Deque<String> deque = new LinkedList<>();
            if (n != 0) {
                String[] numbers = input.substring(1, input.length() - 1).split(",");
                Collections.addAll(deque, numbers);
            }



            int direct = 0; // 0 이면 정방향, 1이면 역방향
            boolean isError = false;
            for (char order: p) {
                if (order == 'R') {
                    direct = (direct + 1) % 2;
                } else {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }

                    if (direct == 0) {
                        deque.removeFirst();
                    } else {
                        deque.removeLast();
                    }
                }
            }

            if (isError) {
                answer.append("error").append("\n");
            } else {
                StringBuilder temp = new StringBuilder();
                temp.append("[");
                if (direct == 0) {
                    while (!deque.isEmpty()) {
                        temp.append(deque.removeFirst()).append(",");
                    }
                } else {
                    while (!deque.isEmpty()) {
                        temp.append(deque.removeLast()).append(",");
                    }
                }

                if (temp.length() > 1) {
                    temp.setLength(temp.length() - 1);
                }

                temp.append("]").append("\n");

                answer.append(temp);
            }
        }

        System.out.println(answer);
    }

}
