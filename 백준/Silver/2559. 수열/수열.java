import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] S = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                S[i] = Integer.parseInt(st.nextToken());
            } else {
                S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
            }
        }

        int max = S[K - 1];
        for (int i = 0; i < N - K; i++) {
            max = Math.max(max, S[i + K] - S[i]);
        }

        System.out.println(max);
    }
}
/*
S[j] - S[i] -> i + 1 부터 j까지의 합
연속된 K 일 간의 합 -> S[i + K] - S[i] => i + 1 <= <= i + K
=> i + K - i - 1 + 1 = K개

시간복잡도 : O(N)
 */