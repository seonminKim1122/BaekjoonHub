import java.util.*;

class Solution {
    public long solution(String numbers) {
        long answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        init(map);
        
        int start = 0;
        while (start < numbers.length()) {
            // 3
            String temp = numbers.substring(start, start + 3);
            if (map.getOrDefault(temp, -1) != -1) {
                answer = answer * 10 + map.get(temp);
                start += 3;
                continue;
            }
            // 4
            temp = numbers.substring(start, start + 4);
            if (map.getOrDefault(temp, -1) != -1) {
                answer = answer * 10 + map.get(temp);
                start += 4;
                continue;
            }
            
            // 5
            temp = numbers.substring(start, start + 5);
            answer = answer * 10 + map.get(temp);
            start += 5;
        }
        
        return answer;
    }
    
    void init(Map<String, Integer> map) {
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
    }
}