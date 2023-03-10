import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int val = 0;

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());

            if(a > val) { // 아직 스택에 담긴 적 없는 값이다
                // push
                for (int j = val; j < a; j++) {
                    stack.push(++val);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else { // 스택에 담긴 적 있는 값 이다
                // a가 스택에 없을 때
                if (stack.isEmpty() || stack.peek() < a){
                    sb.setLength(0);
                    sb.append("NO\n"); // 이미 있던 버퍼를 비워야 NO만 출력할 수 있는데..
                    break;
                } else { // a가 스택에 있을 때
                    while (stack.peek() != a) {
                        stack.pop();
                        sb.append("+\n");
                    }
                    stack.pop();
                    sb.append("-\n");
                }
            }
        }
        br.close();
        System.out.print(sb.toString());
    }
}