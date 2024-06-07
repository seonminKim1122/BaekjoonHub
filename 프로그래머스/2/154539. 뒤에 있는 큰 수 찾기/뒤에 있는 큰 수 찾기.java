import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int N = numbers.length;
        // -1 로 초기화
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = -1;
        }
        
        // 뒷 큰수 찾기
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int number = numbers[i];
            while (!stack.isEmpty() && stack.peek()[1] < number) {
                int[] temp = stack.pop();
                answer[temp[0]] = number;
            }
            stack.push(new int[]{i, number});
        }
        
        return answer;
    }
}