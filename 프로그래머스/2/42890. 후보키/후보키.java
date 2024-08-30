import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        
        boolean[] choices = new boolean[relation[0].length];
        answer = solve(relation, 0, 0, choices);
        
        return answer;
    }
    
    public int solve(String[][] relation, int depth, int start, boolean[] choices) {
        if (isCandidateKey(relation, choices)) {
            return 1;
        }
        
        if (depth == choices.length) {
            return 0;
        }
        
        int result = 0;
        for (int i = start; i < choices.length; i++) {
            choices[i] = true;
            result += solve(relation, depth + 1, i + 1, choices);
            choices[i] = false;
        }
        
        return result;
    }
    
    public boolean isCandidateKey(String[][] relation, boolean[] choices) {
        return isUnique(relation, choices) && isMinimum(relation, choices);
    }
    
    public boolean isUnique(String[][] relation, boolean[] choices) {
        Set<String> tuples = new HashSet<>();
        
        for (int row = 0; row < relation.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < choices.length; col++) {
                if (choices[col]) {
                    sb.append(relation[row][col]);
                }
            }
            
            tuples.add(sb.toString());
        }
        
        return tuples.size() == relation.length;
    }
    
    public boolean isMinimum(String[][] relation, boolean[] choices) {
        for (int i = 0; i < choices.length; i++) {
            if (!choices[i]) continue;
            choices[i] = false;
            if (isUnique(relation, choices)) {
                choices[i] = true;
                return false;
            }
            choices[i] = true;
        }
        return true;
    }
}
/*
후보키

유일성 Check


*/