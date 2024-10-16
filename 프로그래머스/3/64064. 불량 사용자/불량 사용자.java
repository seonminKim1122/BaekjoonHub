import java.util.*;

class Solution {
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = solve(user_id, banned_id, 0, 0,
                          new boolean[banned_id.length], new String[banned_id.length],
                          new HashSet<>());
        return answer;
    }
    
    int solve(String[] user_id, String[] banned_id, int start, int depth, 
              boolean[] used, String[] path, Set<String> resultSet) {
        if (depth == banned_id.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                sb.append(path[i]);
            }
            if (resultSet.contains(sb.toString())) return 0;
            resultSet.add(sb.toString());
            return 1;
        }
        
        int result = 0;
        for (int i = start; i < user_id.length; i++) {
            for (int j = 0; j < banned_id.length; j++) {
                if (used[j]) continue;
                if (!isSimilar(user_id[i], banned_id[j])) continue;
                used[j] = true;
                path[depth] = user_id[i];
                result += solve(user_id, banned_id, i + 1, depth + 1, used, path, resultSet);
                used[j] = false;
                path[depth] = null;
            }
        }
        
        return result;
    }
    
    boolean isSimilar(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) return false;
        
        int size = userId.length();
        for (int i = 0; i < size; i++) {
            if (bannedId.charAt(i) == '*') continue;
            if (userId.charAt(i) != bannedId.charAt(i)) return false;
        }
        
        return true;
    }
}