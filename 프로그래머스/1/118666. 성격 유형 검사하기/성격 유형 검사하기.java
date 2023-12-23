import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> points = new HashMap<>();
        String[] types = {"R", "T", "C", "F", "J", "M", "A", "N"};
        for (String type : types) {
            points.put(type, 0);
        }
        
        for (int i = 0; i < choices.length; i++) {
            int choice = choices[i];
            String[] s = survey[i].split("");
            
            if (choice < 4) {
                points.put(s[0], points.get(s[0]) + 4 - choice);
            } else if (choice > 4) {
                points.put(s[1], points.get(s[1]) + choice - 4);
            }
        }
        
        String answer = "";
        for (int i = 0; i < 8; i += 2) {
            String type1 = types[i];
            String type2 = types[i + 1];
            
            if (points.get(type1) >= points.get(type2)) {
                answer += type1;
            } else {
                answer += type2;
            }
        }
        
        return answer;
    }
}
/*

"AN", 5 -> N 1점
"CF", 3 -> C 1점
"MJ" 2 -> M 2점
"RT" 7 -> T 3점
"NA" 5 -> A 1점

T vs R -> 3 vs 0 -> T
C vs F -> 1 vs 0 -> C
J vs M -> 0 vs 2 -> M
A vs N -> 1 vs 1 -> A

*/