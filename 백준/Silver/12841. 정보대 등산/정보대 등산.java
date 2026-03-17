import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] crossWalks = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            crossWalks[i] = Integer.parseInt(st.nextToken());
        }

        long[] left = new long[n + 1];    // left[i]: 1 ~ i 까지 비용
        st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            left[i] = left[i - 1] + Long.parseLong(st.nextToken());
        }
        long[] right = new long[n + 1];   // right[i]: 1 ~ i 까지 비용
        st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            right[i] = right[i - 1] + Long.parseLong(st.nextToken());
        }

        /**
         * k번째 횡단보도에서 건넌다
         * left[k] + crossWalks[k] + right[n] - right[k]
         */
        long[] cost = new long[n + 1];
        int pos = 0;
        long min = Long.MAX_VALUE;
        for (int k = 1; k <= n; k++) {
            cost[k] = left[k] + crossWalks[k] + right[n] - right[k];
            if (cost[k] < min) {
                min = cost[k];
                pos = k;
            }
        }
        System.out.println(pos + " " + min);
    }
}