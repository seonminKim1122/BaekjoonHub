import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 손질해야 하는 김밥의 개수
        int K = Integer.parseInt(st.nextToken()); // 꼬다리 길이
        int M = Integer.parseInt(st.nextToken()); // 김밥 조각의 최소 개수

        int[] gimBabs = new int[N];
        for (int i = 0; i < N; i++) {
            int gimBab = Integer.parseInt(br.readLine());
            
            if (gimBab >= 2*K) {
                gimBab -= 2*K;
            } else if (gimBab > K) {
                gimBab -= K;
            } else {
                gimBab = 0;
            }

            gimBabs[i] = gimBab;
        }

        int start = 1;
        int end = 1_000_000_000;

        while (start <= end) {
            int P = (start + end) / 2;

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += (gimBabs[i] / P);
            }

            if (cnt >= M) {
                start = P + 1;
            } else {
                end = P - 1;
            }
        }

        System.out.println(end == 0 ? -1 : end);
    }
}