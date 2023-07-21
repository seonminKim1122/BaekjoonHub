import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String formula = br.readLine();

        Stack<Character> operators = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (char c : formula.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                sb.append(c);
            } else {
                if (c != '(' && c != ')') {
                    while (!operators.isEmpty() && priority(operators.peek()) >= priority(c)) {
                        sb.append(operators.pop());
                    }
                    operators.push(c);
                } else {
                    if (c == '(') {
                        operators.push(c);
                    } else {
                        while (!operators.isEmpty() && operators.peek() != '(') {
                            sb.append(operators.pop());
                        }
                        operators.pop();
                    }
                }
            }
        }

        while (!operators.isEmpty()) {
            sb.append(operators.pop());
        }

        System.out.println(sb);
    }

    public static int priority(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/'){
            return 2;
        } else {
            return 0;
        }
    }
}