import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        while (true) {
            String tree = br.readLine();

            if (tree == null || tree.equals("")) break;

            map.put(tree, map.getOrDefault(tree, 0) + 1);
            count++;
        }

        List<String> trees = new ArrayList<>(map.keySet());
        trees.sort(String::compareTo);

        StringBuilder sb = new StringBuilder();
        for (String tree : trees) {
            double ratio = 100 * ((double) map.get(tree) / count);
            sb.append(tree).append(" ").append(String.format("%.4f", ratio)).append("\n");
        }

        System.out.println(sb);
    }
}