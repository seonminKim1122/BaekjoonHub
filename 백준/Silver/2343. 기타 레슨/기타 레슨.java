import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 강의의 수
        int M = Integer.parseInt(st.nextToken()); // 블루레이의 수

        st = new StringTokenizer(br.readLine());
        int[] lectures = new int[N];
        int start = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start, lectures[i]);
            end += lectures[i];
        }

        while (start <= end) {
            int mid = (start + end) / 2;

            int cnt = 1;
            int temp = 0;
            for (int i = 0; i < N; i++) {
                temp += lectures[i];
                if (temp > mid) {
                    cnt++;
                    temp = lectures[i];
                }
            }

            if (cnt <= M) { // mid 가 크다!
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}