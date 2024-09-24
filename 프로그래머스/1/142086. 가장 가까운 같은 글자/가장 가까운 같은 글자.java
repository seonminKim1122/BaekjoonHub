import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] lastIndexOfAlphabet = new int[26];
        Arrays.fill(lastIndexOfAlphabet, -1);

        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char alphabet = s.charAt(i);
            if(lastIndexOfAlphabet[alphabet - 'a'] == -1) {
                answer[i] = lastIndexOfAlphabet[alphabet - 'a'];
            } else {
                answer[i] = i - lastIndexOfAlphabet[alphabet - 'a'];
            }

            lastIndexOfAlphabet[alphabet - 'a'] = i;
        }
        
        return answer;
    }
}