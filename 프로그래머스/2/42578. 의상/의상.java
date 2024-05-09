import java.util.*;

class Solution {
    
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        
        int N = clothes.length;
        for (int i = 0; i < N; i++) {
            String category = clothes[i][1];
            map.put(category, map.getOrDefault(category, 1) + 1);
        }
            
        List<String> categories = new ArrayList<>();
        for (String category: map.keySet()) {
            categories.add(category);
        }
        
        for (String category : categories) {
            answer *= map.get(category);
        }
        
        
        return answer - 1;
    }
}

/*

2 1 3

2C1 + 1C1 + 3C1

+ 2C1 * 1C1
+ 2C1 * 3C1
+ 1C1 * 3C1

+ 2C1 * 1C1 * 3C1

headgear : 2
eyewear: 1

2, 1, 2 -> 5

(2 1)

6 - (2 + 1) * (1 + 1) - 1 
*/