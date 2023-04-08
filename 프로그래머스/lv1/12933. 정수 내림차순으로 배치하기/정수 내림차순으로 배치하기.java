import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        String s = String.valueOf(n);
        String[] numbers = s.split("");
        Arrays.sort(numbers, Collections.reverseOrder());
        
        String temp = "";
        for(String num : numbers) {
            temp += num;
        }
        long answer = Long.parseLong(temp);
        return answer;
    }
}