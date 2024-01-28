import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> counts = new HashMap<>();
        
        for (int key : tangerine) {
            counts.put(key, counts.getOrDefault(key, 0) + 1);
        }
        
        ArrayList<Integer> keys = new ArrayList<>(counts.keySet());
        Collections.sort(keys, (k1, k2) -> {
            return counts.get(k2) - counts.get(k1);
        });
        
        int cnt = 0;
        for (int key : keys) {
            cnt += counts.get(key);
            answer++;
            if (cnt >= k) break;
        }
        
        return answer;
    }
}