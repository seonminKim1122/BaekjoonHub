import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] places = new int[M];
        for (int i = 0; i < M; i++) {
            places[i] = Integer.parseInt(st.nextToken());
        }

        int result = Math.max(places[0], N - places[M - 1]);
        for (int i = 1; i < M; i++) {
            int diff = places[i] - places[i - 1];
            if (diff % 2 == 0) {
                result = Math.max(result, diff / 2);
            } else {
                result = Math.max(result, diff / 2 + 1);
            }
        }

        System.out.println(result);
    }
}