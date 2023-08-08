import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());

            PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                priorityQueue.add(Long.parseLong(st.nextToken()));
            }

            long result = 0;
            while (priorityQueue.size() >= 2) {
                long a = priorityQueue.poll();
                long b = priorityQueue.poll();

                result += (a + b);
                priorityQueue.add(a + b);
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}