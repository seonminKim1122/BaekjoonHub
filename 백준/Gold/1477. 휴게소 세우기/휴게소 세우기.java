import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int L;
    static int[] restAreas;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 현재 휴게소의 개수
        M = Integer.parseInt(st.nextToken()); // 더 지으려는 휴게소의 개수
        L = Integer.parseInt(st.nextToken()); // 고속도로의 길이 L

        st = new StringTokenizer(br.readLine()); // 현재 휴게소의 위치
        restAreas = new int[N+2];
        for (int i = 1; i < N+1; i++) {
            restAreas[i] = Integer.parseInt(st.nextToken());
        }
        restAreas[N+1] = L;

        Arrays.sort(restAreas);

        int start = 1;
        int end = L - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            int cnt = 0;
            for (int i = 1; i < N+2; i++) {
                cnt += (restAreas[i] - restAreas[i-1] - 1) / mid;
            }

            if (cnt <= M) { // 만족하는 애들 중 최소를 구해야 하니까 <= 
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}