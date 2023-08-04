import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        if (K >= N) {
            System.out.println(0);
        } else {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Set<Integer> sensorSet = new HashSet<>();

            for (int i = 0; i < N; i++) {
                sensorSet.add(Integer.parseInt(st.nextToken()));
            }

            List<Integer> sensors = new ArrayList<>(sensorSet);
            Collections.sort(sensors);

            PriorityQueue<Integer> diffs = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < sensors.size()-1; i++) {
                diffs.add(sensors.get(i+1) - sensors.get(i));
            }

            for (int i = 0; i < K-1; i++) {
                diffs.poll();
            }

            int result = 0;
            while (!diffs.isEmpty()) {
                result += diffs.poll();
            }

            System.out.println(result);
        }
    }
}