import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int targetDiff = x - y;

            int a = 1;
            int b = 1;
            int cnt = 1;
            int diff = a - b;

            while (diff != targetDiff && diff != M - N) {
                if (M - a < N - b) {
                    cnt += M - a + 1;
                    b += M - a + 1;
                    a = 1;
                } else {
                    cnt += N - b + 1;
                    a += N - b + 1;
                    b = 1;
                }
                diff = a - b;
            }

            if (x - a != y - b) {
                sb.append(-1);
            } else {
                cnt += x - a;
                sb.append(cnt);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}