import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();

        int cutBarCnt = 0;
        int answer = 0;
        int originBarCnt = 0;
        Stack<String> stack = new Stack<>();
        for (String s : expr.split("")) {
            if (s.equals("(")) {
                cutBarCnt++;
            } else {
                cutBarCnt--;
                if (stack.peek().equals("(")) {
                    answer += cutBarCnt;
                } else {
                    originBarCnt++;
                }
            }
            stack.push(s);
        }
        answer += originBarCnt;
        System.out.println(answer);
    }
}