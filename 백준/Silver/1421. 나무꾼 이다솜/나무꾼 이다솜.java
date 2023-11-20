import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            int tree = Integer.parseInt(br.readLine());
            trees[i] = tree;
            max = Math.max(max, tree);
        }

        long result = 0;
        for (int L = 1; L <= max; L++) {
            long profit = 0;
            for (int i = 0; i < N; i++) {

                int tree = trees[i];
                if (tree < L) continue;

                int cut = 0;
                if (tree % L == 0) {
                    cut += (tree / L) - 1;
                } else {
                    cut += (tree / L);
                }

                int temp = (L * W * (tree / L)) - (cut * C);
                if (temp > 0) profit += temp;
            }
            result = Math.max(result, profit);
        }

        System.out.println(result);
    }
}