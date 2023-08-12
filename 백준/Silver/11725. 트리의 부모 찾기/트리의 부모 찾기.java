import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            String[] input = br.readLine().split(" ");
            graph.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
            graph.get(Integer.parseInt(input[1])).add(Integer.parseInt(input[0]));
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        int[] parents = new int[N+1];
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int parent = queue.poll();
            for (int child : graph.get(parent)) {
                if (!visited[child]) {
                    queue.add(child);
                    visited[child] = true;
                    parents[child] = parent;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N+1; i++) {
            sb.append(parents[i]).append("\n");
        }

        System.out.println(sb);
    }
}