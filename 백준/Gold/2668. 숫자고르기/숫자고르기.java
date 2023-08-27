import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;
    static int[] numbers;
    static boolean[] visited;
    static List<Integer> results = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i < N+1; i++) {
            int number = Integer.parseInt(br.readLine());
            numbers[i] = number;
        }

        for (int i = 1; i < N+1; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(results);

        StringBuilder sb = new StringBuilder();
        sb.append(results.size()).append("\n");
        for (int result : results) {
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int from, int start) {
        if (!visited[numbers[from]]) {
            visited[numbers[from]] = true;
            dfs(numbers[from], start);
            visited[numbers[from]] = false;
        } else {
            if (numbers[from] == start) results.add(start);
        }
    }
}