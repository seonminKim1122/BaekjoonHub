import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        
        int[] init = new int[N];
        int start = 1_000_000_000;
        for (int i = 0; i < N; i++) {
            init[i] = Integer.parseInt(br.readLine());
            start = Math.min(start, init[i]);
        }
        
        int end = start + K;
        while (start <= end) {
            int T = (start + end) / 2;

            long need = 0;
            for (int i = 0; i < N; i++) {
                if (T - init[i] > 0) need += (T - init[i]);
            }

            if (need <= K) {
                start = T + 1;
            } else {
                end = T - 1;
            }
        }

        System.out.println(end);
    }
}