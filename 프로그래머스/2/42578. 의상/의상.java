import java.util.*;

class Solution {
    
    static int answer = -1;
    public int solution(String[][] clothes) {

        Map<String, Integer> map = new HashMap<>();
        
        int N = clothes.length;
        for (int i = 0; i < N; i++) {
            String category = clothes[i][1];
            map.put(category, map.getOrDefault(category, 0) + 1);
        }
            
        List<String> categories = new ArrayList<>();
        for (String category: map.keySet()) {
            categories.add(category);
        }
        
        N = categories.size();
        solve(0, N, categories, 0, 1, map);
        
        return answer;
    }
    
    void solve(int depth, int N, List<String> categories, int start, int temp, Map<String, Integer> map) {
        answer += temp;
        if (depth == N) return;
        
        for (int i = start; i < N; i++) {
            String category = categories.get(i);
            solve(depth + 1, N, categories, i + 1, temp * map.get(category), map);
        }
    }
}

/*
해볼게
*/