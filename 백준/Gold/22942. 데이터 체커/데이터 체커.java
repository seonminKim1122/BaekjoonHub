import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int r = Integer.parseInt(input[1]);

            arr.add(new int[]{x-r, 0, i});
            arr.add(new int[]{x+r, 1, i});
        }

        arr.sort((o1, o2) -> o1[0] - o2[0]);

        String result = "YES";
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int[] temp = arr.get(i);

            if (temp[1] == 0) {
                stack.push(temp[2]);
            } else {
                if (stack.peek() == temp[2]) {
                    stack.pop();
                } else {
                    result = "NO";
                    break;
                }
            }
        }

        System.out.println(result);
    }
}