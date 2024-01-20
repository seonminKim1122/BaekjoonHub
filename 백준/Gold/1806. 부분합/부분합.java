import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] sum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i + 1] = sum[i] + arr[i];
        }

        int start = 0;
        int end = 1;

        int result = Integer.MAX_VALUE;
        while (start <= N && end <= N) {
            int temp = sum[end] - sum[start];
            
            if (temp < S) { // 숫자를 늘려야 함
                end++;
            } else { // 숫자를 줄여야 함
                result = Math.min(end - start, result);
                start++;
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? 0 : result);
    }
}