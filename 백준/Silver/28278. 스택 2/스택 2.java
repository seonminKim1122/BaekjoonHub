import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            int order = input.charAt(0) - '0';

            switch (order) {
                case 2:
                    if (stack.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(stack.pop());
                    }
                    sb.append("\n");
                    break;
                case 3:
                    sb.append(stack.size());
                    sb.append("\n");
                    break;
                case 4:
                    sb.append(stack.isEmpty() ? 1 : 0);
                    sb.append("\n");
                    break;
                case 5:
                    if (stack.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(stack.peek());
                    }
                    sb.append("\n");
                    break;
                default:
                    stack.add(Integer.parseInt(input.split(" ")[1]));
            }
        }

        System.out.println(sb);
    }
}