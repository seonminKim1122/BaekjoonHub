import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> ponketmons = new HashMap<>();
        
        for(int ponketmon : nums) {
            ponketmons.put(ponketmon, (ponketmons.getOrDefault(ponketmon, 0) + 1));
        }
        
        return Math.min(ponketmons.size(), nums.length/2);
    }
}