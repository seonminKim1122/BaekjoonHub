import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        Stack<Integer> t = new Stack<>();

        while (n != 0){
            t.add(n % 3);
            n /= 3;
        }
        int len = t.size();
        for (int i = 0; i < len; i++) {
            answer += t.pop()*(int)Math.pow(3,i);
        }

        return answer;
    }
}