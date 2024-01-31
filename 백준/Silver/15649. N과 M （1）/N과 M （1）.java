import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder answer = new StringBuilder();
    static int[] path;
    static boolean[] via;

    static int N;
    static int M;

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        path = new int[M];
        via = new boolean[N + 1];

        permutation(0);

        System.out.println(answer);
    }

    static void permutation(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                answer.append(path[i]).append(' ');
            }
            answer.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!via[i]) {
                path[depth] = i;
                via[i] = true;
                permutation(depth + 1);
                via[i] = false;
                path[depth] = 0;
            }
        }
    }
}