import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dataStructures = new int[N];
        for (int i = 0; i < N; i++) {
            dataStructures[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (dataStructures[i] == 0) stack.push(number);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder answer = new StringBuilder();
        int V = 0;
        while (!stack.isEmpty() && V < M) {
            answer.append(stack.pop()).append(" ");
            V++;
        }

        while (!queue.isEmpty() && V < M) {
            answer.append(queue.poll()).append(" ");
            V++;
        }

        System.out.println(answer);
    }
}