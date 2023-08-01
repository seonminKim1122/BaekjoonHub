import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int[] diffs = new int[N-1];
        for (int i = 0; i < N-1; i++) {
            diffs[i] = heights[i+1] - heights[i];
        }

        Arrays.sort(diffs);

        int result = 0;
        for (int i = 0; i < N-K; i++) { // 1번 합치면 그룹이 N-1 개 가 됌. K개 그룹이 되기 위해서는 N-K 번 합쳐야 함
            result += diffs[i];
        }

        System.out.println(result);
    }
}