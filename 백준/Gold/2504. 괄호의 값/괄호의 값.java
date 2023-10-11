import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        char[] input = br.readLine().toCharArray();
        int len = input.length;

        int result = 0;
        int temp = 1;

        int type1 = 0;
        int type2 = 0;

        for (int i = 0; i < len; i++) {
            char parenthesis = input[i];

            switch (parenthesis) {
                case ')':
                    if (stack.isEmpty() || stack.peek() == '[') {
                        System.out.println(0);
                        return;
                    }

                    temp /= 2;
                    if (stack.peek() == '(') {
                        result += temp * 2;
                    }

                    type1--;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() == '(') {
                        System.out.println(0);
                        return;
                    }

                    temp /= 3;
                    if (stack.peek() == '[') {
                        result += temp * 3;
                    }

                    type2--;
                    break;
                case '(':
                    temp *= 2;
                    type1++;
                    break;
                case '[':
                    temp *= 3;
                    type2++;
            }
            stack.push(parenthesis);
        }

        if (type1 != 0 || type2 != 0) result = 0;

        System.out.println(result);
    }
}