import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        word = word.toUpperCase();

        int[] alphabetCount = new int[26];
        for (int i = 0; i < word.length(); i++) {
            alphabetCount[word.charAt(i) - 'A']++;
        }

        int max = 0;
        char result = '?';
        for (int i = 0; i < 26; i++) {
            if (max < alphabetCount[i]) {
                max = alphabetCount[i];
                result = (char) (65+i);
            } else if (max == alphabetCount[i]) {
                result = '?';
            }
        }

        System.out.println(result);
    }
}