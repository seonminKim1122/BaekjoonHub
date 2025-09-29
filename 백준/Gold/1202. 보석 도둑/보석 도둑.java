import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 보석의 갯수
        int K = Integer.parseInt(st.nextToken());   // 가방의 갯수

        Jewelry[] jewelries = new Jewelry[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            jewelries[i] = new Jewelry(M, V);
        }

        int[] C = new int[K];
        for (int i = 0; i < K; i++) {
            C[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewelries);
        Arrays.sort(C);

        long result = 0;
        int idx = 0;
        PriorityQueue<Integer> pq  = new PriorityQueue<>(Collections.reverseOrder());
        for (int c : C) {
            while (idx < N && jewelries[idx].M <= c) {
                pq.add(jewelries[idx].V);
                idx++;
            }

            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        System.out.println(result);
    }

    static class Jewelry implements Comparable<Jewelry> {
        int M;
        int V;

        Jewelry(int M, int V) {
            this.M = M;
            this.V = V;
        }

        @Override
        public int compareTo(Jewelry other) {
            return this.M - other.M;
        }
    }
}