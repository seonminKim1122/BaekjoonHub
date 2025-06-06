import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for (int i = N - 1; i >= 0; i--) {
            answer = answer + (money / A[i]);
            money = money % A[i];

            if (money == 0) break;
        }

        System.out.println(answer);
    }
}