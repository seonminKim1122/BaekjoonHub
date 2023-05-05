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

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String poketmon = br.readLine();
            map.put(poketmon, String.valueOf(i+1));
            map.put(String.valueOf(i+1), poketmon);
        }

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            System.out.println(map.get(s));
        }
    }
}