import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewelry[] jewerlies = new Jewelry[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            Jewelry jewelry = new Jewelry(M, V);
            jewerlies[i] = jewelry;
        }
        Arrays.sort(jewerlies, new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                return o1.weight - o2.weight;
            }
        });

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            int bagSize = Integer.parseInt(br.readLine());
            bags[i] = bagSize;
        }
        Arrays.sort(bags);

        PriorityQueue<Jewelry> pq = new PriorityQueue<>();
        int bagIdx = 0;
        int jewelryIdx = 0;
        long result = 0;
        while (bagIdx < K && jewelryIdx < N) {
            Jewelry jewelry = jewerlies[jewelryIdx];
            if (jewelry.weight <= bags[bagIdx]) {
                pq.add(jewelry);
                jewelryIdx++;
            } else {
                if (!pq.isEmpty()) {
                    result += pq.poll().value;
                }
                bagIdx++;
            }
        }

        while (bagIdx < K && !pq.isEmpty()) {
            result += pq.poll().value;
            bagIdx++;
        }

        System.out.println(result);
    }

    static class Jewelry implements Comparable<Jewelry> {
        int weight;
        int value;

        Jewelry(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewelry o) {
            return o.value - this.value;
        }
    }
}