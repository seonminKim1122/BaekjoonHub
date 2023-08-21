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
        int M = Integer.parseInt(st.nextToken());

        int[] T = new int[N]; // T[i] -> i 번 심사대에 앉아있는 심사관이 한 명 심사하는데 드는 시간
        for (int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(T);

        long start = T[0];
        long end = (long)T[0] * M;

        while (start <= end) {
            long mid = (start + end) / 2;

            long temp = 0;
            for (int i = 0; i < N; i++) {
                temp += (mid / T[i]);
            }

            if (temp < M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
}