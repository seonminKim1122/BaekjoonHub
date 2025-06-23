import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        while (T > 0) {
            T--;

            int k = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String order = st.nextToken();
                int v = Integer.parseInt(st.nextToken());

                if (order.equals("I")) {
                    treeMap.put(v, treeMap.getOrDefault(v, 0) + 1);
                } else {
                    if (treeMap.isEmpty()) continue;

                    int number;
                    if (v == 1) {
                        number = treeMap.lastKey();
                    } else {
                        number = treeMap.firstKey();
                    }

                    treeMap.put(number, treeMap.get(number) - 1);

                    if (treeMap.get(number) == 0) {
                        treeMap.remove(number);
                    }
                }
            }

            if (treeMap.isEmpty()) {
                answer.append("EMPTY")
                        .append("\n");
            } else {
                answer.append(treeMap.lastKey())
                        .append(" ")
                        .append(treeMap.firstKey())
                        .append("\n");
            }
        }

        System.out.println(answer);
    }
}
