import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack(N);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (N > 0) {
            String[] order = br.readLine().split(" ");

            switch (order[0]) {
                case "push":
                    stack.push(Integer.parseInt(order[1]));
                    break;
                case "pop":
                    bw.write(String.valueOf(stack.pop()));
                    bw.write("\n");
                    break;
                case "size":
                    bw.write(String.valueOf(stack.size()));
                    bw.write("\n");
                    break;
                case "empty":
                    bw.write(String.valueOf(stack.empty()));
                    bw.write("\n");
                    break;
                default:
                    bw.write(String.valueOf(stack.top()));
                    bw.write("\n");
            }

            N--;
        }

        bw.flush();
        bw.close();
        br.close();

    }

}

class Stack {

    int[] arr;
    int top = -1;

    Stack(int N) {
        arr = new int[N];
    }

    void push(int X) {
        arr[++top] = X;
    }

    int pop() {
        if (size() == 0) return -1;

        return arr[top--];
    }

    int size() {
        return top + 1;
    }

    int empty() {
        return size() == 0 ? 1 : 0;
    }

    int top() {
        if (size() == 0) return -1;

        return arr[top];
    }
}