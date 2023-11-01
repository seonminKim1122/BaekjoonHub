import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] snacks = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int end = 1_000_000_000;

        while (start <= end) {
            int len = (start + end) / 2;

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += snacks[i] / len;
            }

            if (cnt < M) {
                end = len - 1;
            } else {
                start = len + 1;
            }
        }

        System.out.println(start - 1);
    }
}