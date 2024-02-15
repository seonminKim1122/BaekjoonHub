import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] inGame = new boolean[1_000_001];
        int[] cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int end = 0;
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(st.nextToken());
            inGame[card] = true;
            cards[i] = card;
            end = Math.max(end, card);
        }

        int[] point = new int[1_000_001];
        for (int i = 0; i < N; i++) {
            int card = cards[i];
            for (int j = card * 2; j <= end; j += card) {
                if (inGame[j]) {
                    point[card] += 1;
                    point[j] -= 1;
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int card : cards) {
            answer.append(point[card]).append(' ');
        }
        System.out.println(answer);
    }
}