import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        words.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 길이가 다르다면 짧은 것이 먼저 온다.
                if (s1.length() != s2.length()) return s1.length() - s2.length();
                
                // 길이가 같다면 자리수 합이 작은 것이 먼저 온다
                int temp1 = 0;
                for (int i = 0; i < s1.length(); i++) {
                    char c = s1.charAt(i);
                    if ('0' <= c && c <= '9') {
                        temp1 += (c - '0');
                    }
                }
                int temp2 = 0;
                for (int i = 0; i < s2.length(); i++) {
                    char c = s2.charAt(i);
                    if ('0' <= c && c <= '9') {
                        temp2 += (c - '0');
                    }
                }

                if (temp1 != temp2) return temp1 - temp2;

                return s1.compareTo(s2);
            }
        });

        for (String word : words) {
            System.out.println(word);
        }
    }
}