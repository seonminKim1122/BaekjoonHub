import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < ingredient.length; i++) {
            stack.push(ingredient[i]);            
            if (stack.peek() == 1 && stack.size() >= 4) {
                int v1 = stack.pop();
                int v2 = stack.pop();
                int v3 = stack.pop();
                int v4 = stack.pop();

                if (v1 == 1 && v4 == 1 && v2 == 3 && v3 == 2) answer++;
                else {
                    stack.push(v4);
                    stack.push(v3);
                    stack.push(v2);
                    stack.push(v1);
                }
            }
        }
        
        return answer;
    }
}

// stack 활용