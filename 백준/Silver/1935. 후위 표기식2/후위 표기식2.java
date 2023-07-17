import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String postfixExpression = br.readLine();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put((char)(65 + i), Integer.parseInt(br.readLine()));
        }

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < postfixExpression.length(); i++) {
            char ch = postfixExpression.charAt(i);

            if (ch >= 65 && ch <= 90) {
                stack.push((double) map.get((char) ch));
            } else {
                double a = stack.pop();
                double b = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(b + a);
                        break;
                    case '-':
                        stack.push(b - a);
                        break;
                    case '*':
                        stack.push(b * a);
                        break;
                    case '/':
                        stack.push(b / a);
                        break;
                }
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}