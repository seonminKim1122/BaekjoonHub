import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        long sum = 0;
        long[] p = new long[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            sum += Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(p);
        for (int i = N - 1; i >= 0; i--) {
            sum += (p[i] * (--T));
        }

        System.out.println(sum);
    }
}