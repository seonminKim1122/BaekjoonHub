import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            try {
                String[] functions = br.readLine().split("");
                int n = Integer.parseInt(br.readLine());
                String[] temp = br.readLine().replace("[","").replace("]","").split(",");

                Deque<Integer> deque = new LinkedList<>();
                if (n != 0) {
                    for (int j = 0; j < temp.length; j++) {
                        int num = Integer.parseInt(temp[j]);
                        deque.add(num);
                    }
                }


                boolean isReversed = false;
                for (String function : functions) {
                    if (function.equals("D")) {
                        if (isReversed) {
                            deque.removeLast();
                        } else {
                            deque.removeFirst();
                        }
                    } else {
                        isReversed = !isReversed;
                    }
                }

                sb.append("[");
                if (isReversed) {
                    while (true) {
                        if (deque.isEmpty()) break;
                        sb.append(deque.pollLast());
                        if (deque.isEmpty()) break;
                        sb.append(",");
                    }
                } else {
                    while (true) {
                        if (deque.isEmpty()) break;
                        sb.append(deque.pollFirst());
                        if (deque.isEmpty()) break;
                        sb.append(",");
                    }
                }
                sb.append("]\n");

            } catch (Exception e) {
                sb.append("error\n");
            }

        }
        System.out.println(sb);
    }
}