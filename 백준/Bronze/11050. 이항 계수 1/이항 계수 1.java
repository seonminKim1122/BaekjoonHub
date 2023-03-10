import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = 1;

        for(int i = N; i > K; i--) {
            result *= i;
        }

        for(int i = N-K; i > 0; i--) {
            result /= i;
        }
        System.out.println(result);
    }
}