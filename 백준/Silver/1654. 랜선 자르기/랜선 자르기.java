import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // Binary Search
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lans = new int[K];
        long start = 0;
        long end = 0;
        for (int i = 0; i < K; i++) {
            lans[i] = Integer.parseInt(br.readLine());
            if (end < lans[i]) {
                end = lans[i];
            }
        }

        long result = 0;

        while (start <= end) { // 정확히 N개를 맞출 수 없는 케이스도 분명 존재할 것
            result = (long) Math.ceil((double)(start + end) / 2);

            int count = 0;
            
            for (int lan : lans) {
                count += lan / result;
            }

            if (count < N) {
                end = result - 1;
            } else {
                start = result + 1;
            }
        }
        System.out.println(start - 1);
    }
}