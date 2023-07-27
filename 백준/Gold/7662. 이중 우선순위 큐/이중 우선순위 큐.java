import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();



        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int j = 0; j < k; j++) {
                String[] input = br.readLine().split(" ");
                int x = Integer.parseInt(input[1]);
                if (input[0].equals("I")) {
                    map.put(x, map.getOrDefault(x, 0) + 1);
                } else {
                    if (!map.isEmpty()) {
                        if (x == -1) {
                            int min = map.firstKey();
                            map.put(min, map.get(min) - 1);
                            if (map.get(min) <= 0) {
                                map.remove(min);
                            }
                        } else {
                            int max = map.lastKey();
                            map.put(max, map.get(max) - 1);
                            if (map.get(max) <= 0) {
                                map.remove(max);
                            }
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
