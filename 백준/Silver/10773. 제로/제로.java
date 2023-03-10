import java.io.*;
public class Main {

    static int[] stack = new int[100000];
    static int top = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                pop();
            } else {
                push(N);
            }
        }

        int result = 0;
        for (int num : stack) {
            result += num;
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void push(int X) {
        stack[++top] = X;
    }

    public static void pop() {
        stack[top--] = 0;
    }

}