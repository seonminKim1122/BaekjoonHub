import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        int start = 0;
        int end = 9;
        for (int i = start; i <= end; i++) {
            String item = discount[i];
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        
        
        
        while (true) {
            if (canRegister(want, number, map)) answer++;
            
            String minusItem = discount[start++];
            map.put(minusItem, map.get(minusItem) - 1);
            
            end++;
            if (end >= discount.length) break;
            
            String plusItem = discount[end];
            map.put(plusItem, map.getOrDefault(plusItem, 0) + 1);
        }
        
        
        return answer;
    }
    
    public boolean canRegister(String[] want, int[] number, Map<String, Integer> map) {
        int len = number.length;
        
        for (int i = 0; i < len; i++) {
            String item = want[i];
            int count = number[i];
            
            if (map.getOrDefault(item, -1) != count) return false;
        }
        
        return true;
    }
}

/*
카운팅을 위한 HashMap + 슬라이딩 윈도우

start = 0, end = 9

chicken: 1
apple: 3
banana: 2
rice: 2
pork: 2

start = 1, end = 10
chicken: 0
apple: 3
banana: 2
rice: 2
pork: 2
pot: 1

start = 2, end = 11 (O)
chicken: 0
apple: 2
banana: 3
rice: 2
pork: 2
pot: 1 

start = 3, end = 12 (O)
chicken: 0
apple: 2
banana: 3
rice: 2
pork: 2
pot: 1

start = 4, end = 13(O)
chicken: 0
apple: 2
banana: 3
rice: 2
pork: 2
pot: 1

start = 5, end = 14 -> Finish
*/