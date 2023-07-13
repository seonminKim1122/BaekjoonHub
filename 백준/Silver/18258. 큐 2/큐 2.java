import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue queue = new Queue();

        for (int i = 0; i < N; i++) {
            String[] order = br.readLine().split(" ");

            switch (order[0]) {
                case "push":
                    queue.push(Integer.parseInt(order[1]));
                    break;
                case "pop":
                    sb.append(queue.pop());
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;
                case "front":
                    sb.append(queue.front());
                    sb.append("\n");
                    break;
                default:
                    sb.append(queue.back());
                    sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}

class Queue {
    int[] array = new int[20000001];
    int last = 0;
    int first = 1;

    void push(int x) {
        array[++last] = x;
    }

    int pop() {
        if (isEmpty()) {
            return -1;
        }

        int result = array[first];
        array[first++] = 0;
        return result;
    }

    int size() {
        return Math.max(last - first + 1, 0);
    }

    boolean isEmpty() {
        return last < first;
    }

    int front() {
        if (isEmpty()) {
            return -1;
        }
        return array[first];
    }

    int back() {
        if (isEmpty()) {
            return -1;
        }
        return array[last];
    }
}