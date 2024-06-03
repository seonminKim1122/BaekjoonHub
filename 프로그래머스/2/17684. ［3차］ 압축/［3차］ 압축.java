import java.util.*;

class Solution {
    public int[] solution(String msg) {        
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            String word = String.valueOf((char)('A' + i));
            dictionary.put(word, i + 1);
        }
        
        int lastIndex = 26;
        List<Integer> temp = new ArrayList<>();
        
        while (msg.length() > 0) {
            
            String word = "";
            int i = 0;
            while (i < msg.length()) {
                String next = word + msg.charAt(i++);
                if (dictionary.getOrDefault(next, -1) == -1) {
                    break;
                }
                word = next;
            }
            
            temp.add(dictionary.get(word));
            msg = msg.substring(word.length(), msg.length());
            if (msg.length() > 0) {
                dictionary.put(word + msg.charAt(0), ++lastIndex);
            }
        }
        
        int[] answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }
        
        return answer;
    }
}