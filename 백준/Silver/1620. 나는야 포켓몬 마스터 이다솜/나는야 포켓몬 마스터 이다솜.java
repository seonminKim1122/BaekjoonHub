import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String pokemon = br.readLine();
            map1.put(pokemon, i+1);
            map2.put(i+1, pokemon);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (canBeInteger(input)) {
                sb.append(map2.get(Integer.parseInt(input))).append("\n");
            } else {
                sb.append(map1.get(input)).append("\n");
            }
        }

        System.out.println(sb);
    }
    
    public static boolean canBeInteger(String input) {

        for (char c : input.toCharArray()) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        
        return true;
    }
}