import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, PriorityQueue<Integer>> waits = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            for (int k = 0; k < K; k++) {
                int A = Integer.parseInt(st.nextToken());
                PriorityQueue<Integer> pq = waits.getOrDefault(A, null);
                if (pq == null) {
                    pq = new PriorityQueue<>();
                    pq.add(i);
                    waits.put(A, pq);
                } else {
                    pq.add(i);
                }
            }
        }

        int[] eat = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int chobab = Integer.parseInt(st.nextToken());
            if (!waits.containsKey(chobab)) continue;

            Integer people = waits.get(chobab).poll();
            if (people == null) continue;
            eat[people]++;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(eat[i] + " ");
        }
    }
}
