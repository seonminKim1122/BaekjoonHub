import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];
        for (int i = 0;i < n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int number = 1;
        int idx = 0;
        /**
         * stack.peek() < sequence[idx]
         * => 찾고자 하는 숫자가 아직 stack에 쌓이지 않았으므로
         * => stack.push(number++);
         *
         * stack.peek() == sequence[idx]
         * => 찾고자 하는 숫자를 stack 에서 제거
         *
         * stack.peek() > sequence[idx]
         * => 수열을 만들 수 없으므로 NO
         */

        StringBuilder answer = new StringBuilder();
        while (idx < n) {
            if (stack.isEmpty() || stack.peek() < sequence[idx]) {
                stack.push(number++);
                answer.append("+\n");
            } else if (stack.peek() == sequence[idx]) {
                stack.pop();
                answer.append("-\n");
                idx++;
            } else {
                answer.setLength(0);
                answer.append("NO");
                break;
            }
        }

        System.out.println(answer);
    }
}