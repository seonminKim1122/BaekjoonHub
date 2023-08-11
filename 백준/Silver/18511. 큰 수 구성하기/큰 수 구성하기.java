import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] set = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            set[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(set);
        dfs(0, N, set);
        System.out.println(answer);
    }

    public static void dfs(int now, int target, int[] set) {
        if (now > target) return;
        if (answer < now) answer = now;

        for (int i = set.length-1; i >= 0; i--) {
            dfs(now*10 + set[i], target, set);
        }
    }
}