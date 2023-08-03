import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] losses = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            losses[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(losses);

        long result = 0;
        if (N % 2 != 0) {
            for (int i = 0; i < (N-1) / 2; i++) {
                result = Math.max(result, losses[i] + losses[N-2-i]);
            }
            result = Math.max(result, losses[N-1]);
        } else {
            for (int i = 0; i < N / 2; i++) {
                result = Math.max(result, losses[i] + losses[N-1-i]);
            }
        }

        System.out.println(result);
    }
}