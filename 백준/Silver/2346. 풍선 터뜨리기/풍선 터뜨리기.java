import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            deque.addLast(new int[]{i+1, Integer.parseInt(st.nextToken())});
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            int[] arr = deque.pollFirst();

            // 터진 풍선의 번호 StringBuilder 에 추가
            sb.append(arr[0]).append(" ");

            if (deque.isEmpty()) {
                break;
            }

            // 풍선 안에 담긴 숫자대로 이동
            if (arr[1] < 0) {
                for (int i = arr[1]; i < 0; i++) {
                    deque.addFirst(deque.pollLast());
                }
            } else {
                for (int i = 0; i < arr[1]-1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            }
        }

        System.out.println(sb);
    }
}