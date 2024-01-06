import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();
        char lastCharOfBomb = bomb.charAt(bomb.length() - 1);
        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);
            stack.add(now);

            if (now == lastCharOfBomb) {
                removeBombIfExist(stack, bomb);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result.reverse();

        System.out.println(result.length() == 0 ? "FRULA" : result);
    }

    public static void removeBombIfExist(Stack<Character> stack, String bomb) {
        int len = bomb.length();

        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()) break;
            temp.append(stack.pop());
        }

        temp.reverse();

        if (!temp.toString().equals(bomb)) {
            for (int i = 0; i < temp.length(); i++) {
                stack.add(temp.charAt(i));
            }
        }
    }
}