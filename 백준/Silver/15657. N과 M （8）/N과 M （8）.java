import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    static int[] numbers;
    static int[] result;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        result = new int[M + 1];
        dfs(0);
        sb.setLength(sb.length() - 1);

        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int j = 1; j <= M; j++) {
                sb.append(result[j]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int j = 0; j < N; j++) {
            if (result[depth] <= numbers[j]) {
                result[depth + 1] = numbers[j];
                dfs(depth + 1);
            }
        }
    }
}