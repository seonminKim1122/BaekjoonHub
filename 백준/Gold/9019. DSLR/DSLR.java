import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(caculator(A, B)).append("\n");
        }

        System.out.println(sb);
    }

    public static String caculator(int A, int B) {
        String result = "";

        Queue<DSLR> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(new DSLR(A, ""));
        visited.add(A);

        while (!queue.isEmpty()) {
            DSLR now = queue.poll();
            int number = now.number;
            String operation = now.operation;

            if (now.number == B) {
                result = now.operation;
                break;
            }

            // D
            int next = (number * 2) % 10000;
            if (!visited.contains(next)) {
                queue.add(new DSLR(next, operation + "D"));
                visited.add(next);
            }
            // S
            next = number - 1 < 0 ? 9999 : number - 1;
            if (!visited.contains(next)) {
                queue.add(new DSLR(next, operation + "S"));
                visited.add(next);
            }
            // L
            next = (number % 1000) * 10 + number / 1000;
            if (!visited.contains(next)) {
                queue.add(new DSLR(next, operation + "L"));
                visited.add(next);
            }
            // R
            next = (number % 10) * 1000 + number / 10;
            if (!visited.contains(next)) {
                queue.add(new DSLR(next, operation + "R"));
                visited.add(next);
            }
        }

        return result;
    }
}

class DSLR {

    int number;
    String operation;

    DSLR(int number, String operation) {
        this.number = number;
        this.operation = operation;
    }
}