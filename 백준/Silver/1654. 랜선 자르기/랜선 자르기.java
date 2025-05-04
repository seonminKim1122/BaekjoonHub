import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // K, N
        int K = Integer.parseInt(st.nextToken()); // 1 <= K <= 10,000
        int N = Integer.parseInt(st.nextToken()); // 1 <= N <= 1,000,000

        int[] lans = new int[K];
        for (int i = 0; i < K; i++) {
            lans[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solve(lans, N));
    }

    private static long solve(int[] lans, int N) {
        // lans: 오영식이 보유하고 있는 K 개의 랜선
        // N: 박성원이 캠프 때 쓸 랜선 수

        long start = 1;
        long end = Integer.MAX_VALUE; // 랜선의 길이는 2^31 - 1 보다 작거나 같은 자연수
        long answer = -1;
        while (start <= end) {
            long mid = (start + end) / 2;

            long cnt = calc(lans, mid);
            if (cnt >= N) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }

    private static long calc(int[] lans, long size) {
        long result = 0;

        for (int lan : lans) {
            result += (lan / size);
        }

        return result;
    }
}