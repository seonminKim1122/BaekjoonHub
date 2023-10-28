import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] money = new int[N];
        int start = 1;
        int end = 0;
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            start = Math.max(start, money[i]);
            end += money[i];
        }

        while (start <= end) {
            int K = (start + end) / 2;

            int balance = 0;
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                if (balance < money[i]) {
                    cnt++;
                    balance = K;
                }
                balance -= money[i];
            }

            if (cnt <= M) {
                end = K - 1;
            } else {
                start = K + 1;
            }
        }

        System.out.println(end + 1);
    }
}