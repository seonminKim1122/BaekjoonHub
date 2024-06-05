import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek()[1] > prices[i]) {
                int[] temp = stack.pop();
                answer[temp[0]] = i - temp[0];
            }
            stack.push(new int[]{i, prices[i]});
        }
        
        while (!stack.isEmpty()) {
            int[] temp = stack.pop();
            answer[temp[0]] = N - 1 - temp[0];
        }
        
        return answer;
    }
}

/*
1, 2, 3, 2, 3
단순 2중 for -> 입력값 최대 100,000 개 이므로 시간 초과

1, 2, 3, 4, 2, 1, 3

(i + 1) ~ (N - 1) 중에
prices[i] 보다 작은 값이 등장하는 최초 시점을 알아내는 문제

(0, 1), (1, 2), (2, 3), (4, 2)
*/