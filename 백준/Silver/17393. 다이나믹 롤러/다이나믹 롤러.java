import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long[] B = new long[N];
        for (int i = 0; i < N; i++) {
            B[i] = Long.parseLong(st.nextToken());
        }

        /*
        현재 위치보다 오른쪽에 있는 칸 중에 점도 지수가 현재 칸의 잉크지수 이하인 칸만 칠할 수 있음
        i = 0, A[i] = 50 이라고 가정했을 때
        idx : i+1 ~ N-1 까지의 칸들 주에서
        B[idx] <= A[i] 인 칸만 칠할 수 있다! 
         */
        
        int[] results = new int[N];
        for (int i = 0; i < N; i++) {
            // B 는 정렬된 상태
            int start = i + 1;
            int end = N - 1;
            while (start <= end) {
                int mid = (start + end) / 2;

                if (B[mid] > A[i]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            results[i] = end - i;
        }

        StringBuilder sb = new StringBuilder();
        for (int result : results) {
            sb.append(result).append(" ");
        }

        System.out.println(sb);
    }
}