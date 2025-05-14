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

        int N = Integer.parseInt(st.nextToken()); // 도감에 수록된 포켓몬의 수
        int M = Integer.parseInt(st.nextToken()); // 맞춰야 하는 문제의 개수

        Map<Integer, String> guide1 = new HashMap<>();
        Map<String, Integer> guide2 = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String pokemon = br.readLine();
            guide1.put(i, pokemon);
            guide2.put(pokemon, i);
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String quiz = br.readLine();
            if (isNumber(quiz)) {
                answer.append(guide1.get(Integer.parseInt(quiz)));
            } else {
                answer.append(guide2.get(quiz));
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }

    private static boolean isNumber(String input) {
        for (char c : input.toCharArray()) {
            if (!('0' <= c && c <= '9')) return false;
        }
        return true;
    }
}