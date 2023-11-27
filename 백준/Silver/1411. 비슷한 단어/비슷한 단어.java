import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isSimilar(words[i], words[j])) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    public static boolean isSimilar(String word1, String word2) {
        HashMap<Character, Character> map = new HashMap<>();
        int len = word1.length();

        for (int i = 0; i < len; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);

            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) return false;
            } else {
                for (char key : map.keySet()) {
                    if (map.get(key) == c2) return false;
                }
                map.put(c1, c2);
            }
        }
        
        return true;
    }
}