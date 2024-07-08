import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        Stack<Character> stack = new Stack<>();
        char[] digits = number.toCharArray();
        
        for (char digit : digits) {
            while (k > 0 && !stack.isEmpty() && stack.peek() < digit) {
                k--;
                stack.pop();
            }
            stack.push(digit);
        }
        
        while (k > 0) {
            k--;
            stack.pop();
        }
        
        for (char digit : stack) {
            answer.append(digit);
        }
        
        return answer.toString();
    }
}