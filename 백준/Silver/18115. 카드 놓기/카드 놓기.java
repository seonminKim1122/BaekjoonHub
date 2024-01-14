import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> floor = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            floor.add(i + 1);
        }
        Deque<Integer> hand = new LinkedList<>();

        for (int i = N - 1; i >= 0; i--) {
            int card = floor.remove();
            if (A[i] == 1) {
                hand.addFirst(card);
            } else if (A[i] == 2) {
                int first = hand.removeFirst();
                hand.addFirst(card);
                hand.addFirst(first);
            } else {
                hand.addLast(card);
            }
        }

        StringBuilder answer = new StringBuilder();
        while (!hand.isEmpty()) {
            answer.append(hand.removeFirst()).append(" ");
        }

        System.out.println(answer);
    }
}