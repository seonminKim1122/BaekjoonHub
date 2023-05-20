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

        Map<String, Integer> wordBook = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                wordBook.put(word, wordBook.getOrDefault(word, 0)+1);
            }
        }
        List<String> wordList = new ArrayList<>(wordBook.keySet());

        wordList.sort((word1, word2) -> {
            if (wordBook.get(word2).equals(wordBook.get(word1))) {
                if (word1.length() == word2.length()) {
                    return word1.compareTo(word2);
                } else {
                    return word2.length() - word1.length();
                }
            } else {
                return wordBook.get(word2) - wordBook.get(word1);
            }
        });

        StringBuilder sb = new StringBuilder();
        wordList.forEach(word -> sb.append(word).append("\n"));
        System.out.println(sb);
    }
}