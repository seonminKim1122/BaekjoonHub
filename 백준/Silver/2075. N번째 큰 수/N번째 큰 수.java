import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int number = Integer.parseInt(st.nextToken());
                priorityQueue.add(number);
            }
        }

        for (int i = 0; i < N-1; i++) {
            priorityQueue.poll();
        }

        int result = priorityQueue.peek();
        System.out.println(result);
    }
}