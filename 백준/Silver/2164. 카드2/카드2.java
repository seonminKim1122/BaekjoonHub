import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> deck = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deck.add(i);
        }

        while (N > 1) {
            // 맨 윗장 버리기
            deck.poll();
            // 현재 맨 윗장을 맨 아래로 옮기기
            deck.add(deck.poll());
            N--;
        }

        System.out.println(deck.poll());
    }



}