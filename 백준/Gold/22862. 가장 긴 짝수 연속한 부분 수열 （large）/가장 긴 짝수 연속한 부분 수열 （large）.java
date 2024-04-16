import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수열 S 의 길이
        int K = Integer.parseInt(st.nextToken()); // 삭제할 수 있는 최대 횟수

        int[] S = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int cntOfOdd = (S[0] % 2 == 0) ? 0 : 1;
        int result = (cntOfOdd == 0) ? 1 : 0;
        int answer = result;
        while (end < N) {
            if (cntOfOdd <= K) {
                end++;
                if (end == N) break;

                if (S[end] % 2 == 0) {
                    result++;
                } else {
                    cntOfOdd++;
                }
            } else {
                if (S[start] % 2 == 0) {
                    result--;
                } else {
                    cntOfOdd--;
                }
                start++;
            }

            answer = Math.max(answer, result);
        }

        System.out.println(answer);
    }
}