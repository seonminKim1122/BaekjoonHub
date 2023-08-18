import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

        int[] lans = new int[K];
        long start = 1;
        long end = 0;
        for (int i = 0; i < K; i++) {
            lans[i] = Integer.parseInt(br.readLine());
            if (end < lans[i]) {
                end = lans[i];
            }
        }

        // N 개를 만들 수 있는 랜선의 최대 길이를 구하라
        while (start <= end) {
            long mid = (start + end) / 2;

            int cnt = 0;
            for (int i = 0; i < K; i++) {
                cnt += (lans[i] / mid);
            }

            if (cnt < N) {
                end = mid - 1;
            } else  {
                start = mid + 1; // == N 도 포함시킨 이유는 == N이 되는 최대를 찾아야 하기 때문
            }
        }

        System.out.println(end);
    }
}