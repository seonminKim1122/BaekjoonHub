import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String[] PS = br.readLine().split("");

            Stack<String> stack = new Stack<>();
            boolean isVPS = true;
            for (String parenthesis : PS) {
                if (parenthesis.equals("(")) {
                    stack.push(parenthesis);
                } else {
                    if (stack.isEmpty()) {
                        isVPS = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (!stack.isEmpty()) {
                isVPS = false;
            }

            if (isVPS) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}