import java.util.*;

class Solution {
    public int solution(String s) {
        // 괄호 초기 형태 저장
		Queue<Character> queue = new LinkedList<>();
        int size = 0;
        for (char parenthesis : s.toCharArray()) {
            queue.add(parenthesis);
            size++;
        }
        
        int answer = 0;
        for (int x = 0; x < size; x++) {
            // 현재 상태가 올바른 괄호인지 체크
            if (isCorrect(queue)) answer++;
            
            // 왼쪽으로 회전
            queue.add(queue.poll());
        }
        
        return answer;
    }
    
    boolean isCorrect(Queue<Character> queue) {
        Stack<Character> stack = new Stack<>();
        
        for (char parenthesis : queue) {
            switch (parenthesis) {
                case '(':
                case '{':
                case '[':
                    stack.push(parenthesis);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') return false;
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') return false;
                    stack.pop();
                    break;
                default:
                    if (stack.isEmpty() || stack.peek() != '{') return false;
                    stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
    
}