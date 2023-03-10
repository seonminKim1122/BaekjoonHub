import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {

        // 뽑을 값과 맨 왼쪽 값이 일치하면 1
        // 그렇지 않으면 2 or 3
        // 2 : 남은 숫자 중 절반 이전의 값일 때
        // 3 : 남은 숫자 중 절반 이후의 값일 때

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int cnt = 0;
        for(int j = 0; j < M; j++) {
            // 뽑아내려는 원소
            int n = Integer.parseInt(st2.nextToken());

            while (deque.peekFirst() != n) {
                if (2 * deque.indexOf(n) < deque.size()) {
                    deque.offerLast(deque.pollFirst());
                } else {
                    deque.offerFirst(deque.pollLast());
                }
                cnt++;
            }
            deque.removeFirst();
        }
        System.out.println(cnt);
    }
}