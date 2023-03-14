import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K+1];
        int[] weights = new int[N];

        // 초기값 셋팅
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int W = Integer.parseInt(st2.nextToken());
            int V = Integer.parseInt(st2.nextToken());

            if(W > K) continue;

            // 입력받은 무게 이상 중 갱신할 값 있는지 확인
            for (int j = K; j >= W; j--) {
                dp[j] = dp[j] < dp[j-W] + V ? dp[j-W] + V : dp[j];
            }
        }
        System.out.println(dp[K]);
    }
}