import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        String lower = my_string.toLowerCase();
        char[] arr = lower.toCharArray();
        Arrays.sort(arr);
        
        answer = String.valueOf(arr);
        return answer;
    }
}