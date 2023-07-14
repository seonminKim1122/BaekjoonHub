import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String order = br.readLine();

            switch (order.charAt(0)) {
                case 's':
                    sb.append(deque.size()).append("\n");
                    break;
                case 'e':
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case 'f':
                    sb.append(deque.isEmpty() ? -1 : deque.getFirst()).append("\n");
                    break;
                case 'b':
                    sb.append(deque.isEmpty() ? -1 : deque.getLast()).append("\n");
                    break;
                default:
                    if (order.charAt(1) == 'u') { // push
                        if (order.charAt(5) == 'f') { // front
                            deque.addFirst(Integer.parseInt(order.substring(11)));
                        } else { // back
                            deque.addLast(Integer.parseInt(order.substring(10)));
                        }
                    } else { // pop
                        if (order.charAt(4) == 'f') { // front
                            sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
                        } else { // back
                            sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
                        }
                    }
            }
        }
        System.out.println(sb);
    }
}