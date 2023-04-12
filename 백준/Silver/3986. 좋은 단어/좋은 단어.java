import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int answer = 0;
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            Stack<String> stack = new Stack<>();
            for(String a : s.split("")) {
                if (stack.isEmpty()) {
                    stack.push(a);
                } else {
                    if(stack.peek().equals(a)) {
                        stack.pop();
                    } else {
                        stack.push(a);
                    }
                }
            }

            if (stack.isEmpty()) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}