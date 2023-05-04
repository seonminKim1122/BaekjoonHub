import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] origin = new int[N];
        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        int[] sorted = origin.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = -1;
        for(int num : sorted) {
            rank = map.getOrDefault(num, -1) == -1 ? rank + 1 : rank;
            map.put(num, rank);
        }

        StringBuilder sb = new StringBuilder();
        for (int num : origin) {
            sb.append(map.get(num)).append(" ");
        }
        System.out.println(sb);
    }
}