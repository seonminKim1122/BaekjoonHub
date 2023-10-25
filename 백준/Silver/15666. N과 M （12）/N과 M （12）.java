import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    static int[] numbers;
    static int[] result;

    static Set<String> printed = new HashSet<>();

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
    }

    public static void dfs(int depth) {
        if (depth == M) {
            StringBuilder temp = new StringBuilder();
            for (int i = 1; i <= M; i++) {
                temp.append(result[i]).append(" ");
            }
            temp.setLength(temp.length() - 1);

            if (!printed.contains(temp.toString())) {
                System.out.println(temp);
                printed.add(temp.toString());
            }

            return;
        }

        for (int i = 0; i < N; i++) {
            if (result[depth] <= numbers[i]) {
                result[depth + 1] = numbers[i];
                dfs(depth + 1);
            }
        }
    }
}