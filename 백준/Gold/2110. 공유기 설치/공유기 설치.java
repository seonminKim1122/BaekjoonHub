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
        int C = Integer.parseInt(st.nextToken());

        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            int house = Integer.parseInt(br.readLine());
            houses[i] = house;
        }

        Arrays.sort(houses);

        int start = 1;
        int end = houses[N-1] - houses[0];

        while (start <= end) {
            int mid = (start + end) / 2;

            int cnt = 1;
            int beforeIdx = 0;
            for (int i = 1; i < N; i++) {
                if (houses[i] - houses[beforeIdx] >= mid) {
                    cnt++;
                    beforeIdx = i;
                }
            }

            if (cnt < C) { // mid 가 작다
                end = mid - 1;
            } else { // mid 가 크다
                start = mid + 1;
            }
        }

        System.out.println(end);
    }
}