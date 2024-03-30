import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] H = new int[N];
        for (int i = 0; i < N; i++) {
            H[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N + 1];
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            result[a - 1] += k;
            result[b] -= k;
        }

        int[] S = new int[N];
        S[0] = result[0];
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + result[i];
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            answer.append(S[i] + H[i]).append(' ');
        }

        System.out.println(answer);
    }
}