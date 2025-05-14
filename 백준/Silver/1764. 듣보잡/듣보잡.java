import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set1 = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine(); // 듣도 못한 사람
            set1.add(name);
        }

        List<String> names = new ArrayList<>();
        for (int j = 0; j < M; j++) {
            String name = br.readLine(); // 보도 못한 사람
            if (set1.contains(name)) {
                names.add(name);
            }
        }
        names.sort(String::compareTo);

        StringBuilder answer = new StringBuilder();
        answer.append(names.size()).append("\n");
        for (String name : names) {
            answer.append(name).append("\n");
        }

        System.out.println(answer);
    }
}