import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<ElectricWire> electricWires = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            ElectricWire electricWire = new ElectricWire(A, B);
            electricWires.add(electricWire);
        }

        Collections.sort(electricWires);

        // B 값을 기준으로 LIS 만들기!!
        int[] LIS = new int[N];
        LIS[0] = 1;

        int maxLIS = 1;
        for (int i = 1; i < N; i++) {
            LIS[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (electricWires.get(j).B <= electricWires.get(i).B) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
            maxLIS = Math.max(maxLIS, LIS[i]);
        }

        System.out.println(N - maxLIS);
    }

    static class ElectricWire implements Comparable<ElectricWire> {
        int A;
        int B;

        ElectricWire(int A, int B) {
            this.A = A;
            this.B = B;
        }

        @Override
        public int compareTo(ElectricWire other) {
            if (this.A == other.A) {
                return this.B - other.B;
            } else {
                return this.A - other.A;
            }
        }

        @Override
        public String toString() {
            return "ElectricWire{" +
                    "A=" + A +
                    ", B=" + B +
                    '}';
        }
    }
}
