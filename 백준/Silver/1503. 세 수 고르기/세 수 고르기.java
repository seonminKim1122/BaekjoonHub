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

        if (M == 0) {
            System.out.println(0);
            return;
        }

        boolean[] S = new boolean[1002];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            S[num] = true;
        }

        int result = Math.abs(N - 51 * 51 * 51);
        for (int x = 1; x <= 1001; x++) {
            if (S[x]) continue;
            for (int y = 1; y <= 1001; y++) {
                if (S[y]) continue;
                for (int z = 1; z <= 1001; z++) {
                    if (S[z]) continue;
                    result = Math.min(result, Math.abs(N - x * y * z));
                }
            }
        }

        System.out.println(result);
    }
}