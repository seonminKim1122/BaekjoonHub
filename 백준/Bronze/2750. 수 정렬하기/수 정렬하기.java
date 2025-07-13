import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 100000 * 999;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(br.readLine());
        }

        bubbleSort(cards);

        for (int i = 0; i < N; i++) {
            System.out.println(cards[i]);
        }
    }

    static void bubbleSort(int[] cards) {
        int numOfCards = cards.length;

        for (int i = 0; i < numOfCards; i++) {
            for (int j = 0; j < numOfCards - 1 - i; j++) {
                if (cards[j] > cards[j + 1]) {
                    int temp = cards[j];
                    cards[j] = cards[j + 1];
                    cards[j + 1] = temp;
                }
            }
        }
    }
}