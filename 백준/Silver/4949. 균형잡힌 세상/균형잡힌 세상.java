import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String text = br.readLine();
            Stack<String> stack = new Stack<>();
            String ans = "yes";

            if (text.equals(".")) {
                break;
            }

            if (isBalanced(text)) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static boolean isBalanced(String text) {
        Stack<String> stack = new Stack<>();

        for (String s : text.split("")) {
            switch (s) {
                case "(":
                    stack.push(s);
                    break;
                case "[":
                    stack.push(s);
                    break;
                case ")":
                    if(!stack.isEmpty() && stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case "]":
                    if(!stack.isEmpty() && stack.peek().equals("[")) {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }

        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}