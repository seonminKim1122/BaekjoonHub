import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue queue = new Queue(N);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (N > 0) {
            String[] order = br.readLine().split(" ");

            switch (order[0]) {
                case "push":
                    queue.push(Integer.parseInt(order[1]));
                    break;
                case "pop":
                    bw.write(String.valueOf(queue.pop()));
                    bw.write("\n");
                    break;
                case "size":
                    bw.write(String.valueOf(queue.size()));
                    bw.write("\n");
                    break;
                case "empty":
                    bw.write(queue.isEmpty() ? "1" : "0");
                    bw.write("\n");
                    break;
                case "front":
                    bw.write(String.valueOf(queue.front()));
                    bw.write("\n");
                    break;
                default:
                    bw.write(String.valueOf(queue.back()));
                    bw.write("\n");
            }

            N--;
        }

        bw.flush();
        bw.close();
        br.close();

    }

}

class Queue {
    int[] arr;
    int front = 0;
    int rear = -1;

    Queue(int N) {
        arr = new int[N];
    }

    void push(int X) {
        arr[++rear] = X;
    }

    int pop() {
        if(isEmpty()) return -1;
        return arr[front++];
    }

    int size() {
        return isEmpty() ? 0 : rear - front + 1;
    }

    boolean isEmpty() {
        return rear - front < 0;
    }

    int front() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    int back() {
        if (isEmpty()) return -1;
        return arr[rear];
    }
}