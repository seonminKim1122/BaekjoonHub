import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        
        List<String> temp = new ArrayList<>();
        for (int num : course) {
            
            Map<String, Integer> countMap = new HashMap<>();
            for (String order : orders) {
                char[] orderArray = order.toCharArray();
                Arrays.sort(orderArray);
                solve(orderArray, 0, num, 0, new int[num], countMap);
            }
                        
            int max = -1;
            for (int count : countMap.values()) {
                if (max < count) max = count;
            }
            
            if (max < 2) continue;
            
            for (String key : countMap.keySet()) {
                int count = countMap.get(key);
                if (count == max) {
                    temp.add(key);
                }
            }
        }

        String[] answer = new String[temp.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = temp.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    void solve(char[] order, int level, int max, int start, int[] path, Map<String, Integer> countMap) {
        if (level == max) {
            String menu = "";
            for (int i = 0; i < max; i++) {
                menu += order[path[i]];
            }

            countMap.put(menu, countMap.getOrDefault(menu, 0) + 1);
            return;
        }
        
        for (int i = start; i < order.length; i++) {
            path[level] = i;
            solve(order, level + 1, max, i + 1, path, countMap);
        }
    }
    
}

/*

*/