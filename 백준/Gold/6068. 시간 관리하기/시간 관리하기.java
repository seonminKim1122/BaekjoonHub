import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> works = new PriorityQueue<>((w1, w2) -> w1[1] - w2[1]);
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            int cost = Integer.parseInt(input[0]);
            int dueTime = Integer.parseInt(input[1]);

            int[] work = new int[]{cost, dueTime};
            works.add(work);
        }

        int wakeUp = 1_000_000;
        int time = 0;
        while (!works.isEmpty()) {
            int[] now = works.poll();

            if (time <= (now[1] - now[0])) {
                time += now[0];
                wakeUp = Math.min(wakeUp, (now[1] - time));
            } else {
                wakeUp = -1;
                break;
            }
        }

        System.out.println(wakeUp);
    }
}