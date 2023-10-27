import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int J = Integer.parseInt(st.nextToken()); // 사탕의 개수
            int N = Integer.parseInt(st.nextToken()); // 상자의 개수

            int[] boxes = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int R = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());

                boxes[i] = R * C;
            }

            Arrays.sort(boxes);

            int idx = N - 1;
            while (J > 0) {
                J -= boxes[idx--];
            }

            sb.append(N - 1 - idx).append("\n");
        }

        System.out.println(sb);
    }
}