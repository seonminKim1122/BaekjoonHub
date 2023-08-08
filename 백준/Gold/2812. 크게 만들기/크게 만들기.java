import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String number = br.readLine();

        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            int num = (int)(number.charAt(i) - '0');
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && count < K && stack.peek() < num) {
                    stack.pop();
                    count++;
                }
            }
            stack.add(num);
        }

        while(stack.size() > N-K){
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb.reverse());
    }
}