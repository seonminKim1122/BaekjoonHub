import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 스태프의 수
        int M = Integer.parseInt(st.nextToken()); // 풍선의 개수

        int[] staffs = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            staffs[i] = Integer.parseInt(st.nextToken());
        }

        long start = 0;
        long end = 1_000_000 * 1_000_000L;

        while (start <= end) {
            long mid = (start + end) / 2;

            long ballons = 0;
            for (int i = 0; i < N; i++) {
                ballons += (mid / staffs[i]);
            }

            if (ballons < M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
}