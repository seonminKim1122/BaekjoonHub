import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] needs = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            needs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(needs);
        int[] sums = new int[n];
        sums[0] = needs[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + needs[i];
        }

        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            result += needs[i] * (sums[n - 1] - sums[i]);
        }

        System.out.println(result);
    }
}