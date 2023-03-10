import java.io.*;
public class Main {

    static int[] queue = new int[2000000];
    static int size = 0;
    static int front = 0;
    static int back = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String[] order = br.readLine().split(" ");

            switch (order[0]) {
                case "push":
                    push(Integer.parseInt(order[1]));
                    break;
                case "pop":
                    bw.write(pop() + "\n");
                    break;
                case "size":
                    bw.write(size() + "\n");
                    break;
                case "empty":
                    bw.write(empty() + "\n");
                    break;
                case "front":
                    bw.write(front() + "\n");
                    break;
                case "back":
                    bw.write(back() + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static void push(int X) {
        queue[back++] = X;
        size++;
    }

    public static int pop() {
        if (size == 0) {
            return -1;
        } else {
            size--;
            return queue[front++];
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if (size == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int front() {
        if (size == 0) {
            return -1;
        } else {
            return queue[front];
        }
    }

    public static int back() {
        if (size == 0) {
            return -1;
        } else {
            return queue[back-1];
        }
    }
}