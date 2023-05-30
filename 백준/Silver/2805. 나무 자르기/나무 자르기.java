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

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] trees = new int[N];
        int start = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st2.nextToken());
            if (end < trees[i]) {
                end = trees[i];
            }
        }

        while (start <= end) {
            int mid = (int) Math.ceil((double)(start + end) / 2);

            long length = 0;
            for(int tree : trees) {
                if (tree - mid > 0) {
                    length += tree - mid;
                }
            }

            if (length < M) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start - 1);
    }
}