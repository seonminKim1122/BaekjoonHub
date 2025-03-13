import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (T > 0) {
            String PS = br.readLine();

            Stack<Character> stack = new Stack<>();
            boolean isValid = true;
            for (char parenthesis: PS.toCharArray()) {
                if (parenthesis == '(') {
                    stack.add(parenthesis);
                } else {
                    if (stack.isEmpty()) {
                        isValid = false;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (!stack.isEmpty()) isValid = false;

            bw.write(isValid ? "YES" : "NO");
            bw.write("\n");

            T--;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}