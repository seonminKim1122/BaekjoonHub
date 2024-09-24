import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] needToEnter = new int[26];
        for (int i = 0; i < keymap.length; i++) {
            String key = keymap[i];
            
            for (int j = 0; j < key.length(); j++) {
                char c = key.charAt(j);
                int idx = c - 'A';
                
                if (needToEnter[idx] == 0) {
                    needToEnter[idx] = j + 1;
                } else {
                    needToEnter[idx] = Math.min(needToEnter[idx], j + 1);
                }
            }
        }
        
        
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            
            for (int j = 0; j < target.length(); j++) {
                char c = target.charAt(j);
                int idx = c - 'A';
                
                if (needToEnter[idx] == 0) {
                    answer[i] = -1;
                    break;
                } else {
                    answer[i] += needToEnter[idx];
                }
            }
        }
        return answer;
    }
}