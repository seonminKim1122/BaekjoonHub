import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] x = new long[N];
        long[] y = new long[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        double result = 0;
        for (int i = 0; i < N; i++) {
            result += (x[i] * y[(i + 1) % N]);
            result -= (y[i] * x[(i + 1) % N]);
        }
        result = Math.abs(result) / 2;
        System.out.printf("%.1f", result);
    }
}
/*
10,000,000,000
 */