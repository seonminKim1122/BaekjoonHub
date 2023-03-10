import java.io.*;
public class Main {

    static int[] stack = new int[100000];
    static int top = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
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
                case "top":
                    bw.write(top() + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void push(int X) {
        stack[++top] = X;
    }

    public static int pop() {
        if (empty() == 1) {
            return -1;
        }
        return stack[top--];
    }

    public static int size() {
        return top + 1;
    }

    public static int empty() {
        if (top == -1) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int top() {
        if (empty() == 1) {
            return -1;
        }
        return stack[top];
    }
}