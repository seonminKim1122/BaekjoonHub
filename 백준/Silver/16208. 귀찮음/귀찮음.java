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
        int totalLength = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            needs[i] = Integer.parseInt(st.nextToken());
            totalLength += needs[i];
        }

        Arrays.sort(needs);

        long result = 0;
        for (int i = 0; i < n - 1; i++) {
            totalLength -= needs[i];
            result += ((long) needs[i] * totalLength);
        }

        System.out.println(result);
    }
}