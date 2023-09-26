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
            S[i] = Integer.parseInt(st.nextToken());
        }

        int L = 0;
        int R = 0;

        int result = 0;
        while (L <= R && L < N && R < N) {
            int oddCnt = countOddNumber(S, L, R);

            if (oddCnt > K) {
                L++;
            } else {
                result = Math.max(result, R - L + 1 - oddCnt);
                R++;
            }
        }

        System.out.println(result);
    }

    public static int countOddNumber(int[] S, int R, int L) {
        int result = 0;
        for (int i = R; i <= L; i++) {
            if (S[i] % 2 != 0) result++;
        }

        return result;
    }
}