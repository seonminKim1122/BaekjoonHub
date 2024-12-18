import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] A;
    static int M;
    static int[] B;

    public static void main(String[] args) throws IOException {
        input();
        Stack<Integer> printer = new Stack<>();
        solve(0, 0, printer);

        System.out.println(printer.size());
        while (!printer.isEmpty()) {
            System.out.print(printer.pop() + " ");
        }
    }

    static void solve(int a, int b, Stack<Integer> printer) {
        int max = 0;
        int nextA = -1;
        int nextB = -1;
        for (int i = a; i < N; i++) {
            for (int j = b; j < M; j++) {
                if (A[i] == B[j] && A[i] > max) {
                    max = A[i];
                    nextA = i;
                    nextB = j;
                }
            }
        }

        if (max != 0) {
            solve(nextA + 1, nextB + 1, printer);
            printer.add(max);
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
    }
}