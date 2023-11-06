import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        /*
        N 이 짝수 : (N / 2) 부터 N - 1 까지의 합 * 2
        N 이 홀수 : (N / 2) + 1 부터 N - 1 까지의 합 * 2 + (N / 2)
         */
        int result = 0;
        for (int i = N / 2; i < N; i++) {
            result += (2 * a[i]);
        }
        result = N % 2 != 0 ? result - a[N / 2] : result;

        System.out.println(result);
    }
}