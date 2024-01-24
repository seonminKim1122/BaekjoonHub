import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> counts = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long number = Long.parseLong(br.readLine());

            counts.put(number, counts.getOrDefault(number, 0) + 1);
        }

        List<Long> numbers = new ArrayList<>(counts.keySet());
        Collections.sort(numbers, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if (counts.get(o1) > counts.get(o2)) {
                    return -1;
                } else if (counts.get(o1) < counts.get(o2)) {
                    return 1;
                } else {
                    if (o1 < o2) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });

        System.out.println(numbers.get(0));
    }
}
