import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        boolean[] visited = new boolean[n];
        Set<Integer> set = new HashSet<>();
        dfs(numbers, k, 0, 0, set, visited);

        System.out.println(set.size());
    }
    
    public static void dfs(int[] numbers, int k, int number, int depth, Set<Integer> set, boolean[] visited) {
        if (depth == k) {
            set.add(number);
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (numbers[i] >= 10) {
                    dfs(numbers, k, number*100 + numbers[i], depth+1, set, visited);
                } else {
                    dfs(numbers, k, number*10 + numbers[i], depth+1, set, visited);
                }
                visited[i] = false;
            }
        }
    }
}