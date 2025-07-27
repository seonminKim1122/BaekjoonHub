import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static final int INF = 1000 * 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] expression = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        StringBuilder answer = new StringBuilder();
        for (char c : expression) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty()) {
                    char operator = stack.peek();

                    if (operator == '(') {
                        stack.pop();
                        break;
                    } else {
                        answer.append(stack.pop());
                    }
                }
            } else if (isNotOperator(c)) {
                answer.append(c);
            } else {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(c)) {
                        answer.append(stack.pop());
                    }
                    stack.push(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }

        System.out.println(answer);
    }

    static boolean isNotOperator(char c) {
        return c != '+' && c != '-' && c != '*' && c != '/';
    }

    static int getPriority(char c) {
        if (c == '(') return 0;
        if (c == '+' || c == '-') return 1;
        return 2;
    }
}