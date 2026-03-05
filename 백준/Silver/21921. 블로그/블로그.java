import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] visitors = new int[N];
        for (int i = 0; i < N; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
        }

        int[] sums = new int[N - X + 1];
        for (int i = 0; i < X; i++) {
            sums[0] += visitors[i];
        }

        int max = sums[0];
        for (int i = 1; i <= N - X; i++) {
            sums[i] = sums[i - 1] + visitors[X + i - 1] - visitors[i - 1];
            max = Math.max(max, sums[i]);
        }

        int count = 0;
        for (int i = 0; i <= N - X; i++) {
            if (sums[i] == max) {
                count++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}