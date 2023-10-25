import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] numbers;
    static boolean[] visited;
    static int[] result;

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

        StringBuilder sb = new StringBuilder();
        visited = new boolean[N];
        result = new int[M];
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            result[0] = numbers[i];
            dfs(i, 1);
            visited[i] = false;
            result[0] = 0;
        }
    }

    public static void dfs(int i, int depth) {
        if (depth == M) {
            for (int j = 0; j < M; j++) {
                System.out.print(result[j] + " ");
            }
            System.out.println();
            return;
        }

        for (int j = 0; j < N; j++) {
            if (visited[j]) continue;

            visited[j] = true;
            result[depth] = numbers[j];
            dfs(j, depth + 1);
            visited[j] = false;
            result[depth] = 0;
        }
    }
}