import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        long start = 0;
        long end = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, trees[i]);
        }

        long answer = 0;
        while (start <= end) {
            long H = (start + end) / 2;

            long temp = 0;
            for (int i = 0; i < N; i++) {
                temp += Math.max(0, trees[i] - H);
            }

            if (temp >= M) {
                start = H + 1;
                answer = H;
            } else {
                end = H - 1;
            }
        }

        System.out.println(answer);
    }

}