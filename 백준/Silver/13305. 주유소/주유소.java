import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] distances = new int[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            distances[i] = Integer.parseInt(st.nextToken());
        }

        int[] prices = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(st2.nextToken());
        }

        int minPrice = prices[0];
        int distance = distances[0];
        int result = 0;
        for (int i = 1; i < N-1; i++) {
            if (minPrice > prices[i]) {
                result += (minPrice * distance);
                minPrice = prices[i];
                distance = distances[i];
            } else {
                distance += distances[i];
            }
        }

        result += (minPrice * distance);
        System.out.println(result);
    }
}