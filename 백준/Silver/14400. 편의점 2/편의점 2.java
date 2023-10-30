import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().split(" ")[0]);
        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int xi = Integer.parseInt(st.nextToken());
            int yi  = Integer.parseInt(st.nextToken());

            x[i] = xi;
            y[i] = yi;
        }

        Arrays.sort(x);
        Arrays.sort(y);

        int mid = n / 2;
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.abs(x[i] - x[mid]) + Math.abs(y[i] - y[mid]);
        }

        System.out.println(result);
    }
}