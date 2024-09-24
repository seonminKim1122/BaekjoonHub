import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            String[] now = photo[i];
            int temp = 0;
            for (int j = 0; j < now.length; j++) {
                String key = now[j];
                temp += map.getOrDefault(key, 0);
            }
            answer[i] = temp;
        }
        
        return answer;
    }
}