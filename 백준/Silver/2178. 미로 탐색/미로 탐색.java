import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(input[j]);
            }
        }

        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        int result = 1;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int i = point[0];
            int j = point[1];
            int block = point[2];

            if (i == N-1 && j == M-1) {
                result = block;
            }

            // 상, 하, 좌, 우
            if (i-1 >= 0 && !visited[i-1][j] && maze[i-1][j] != 0) {
                queue.add(new int[]{i-1, j, block+1});
                visited[i-1][j] = true;
            }

            if (i+1 < N && !visited[i+1][j] && maze[i+1][j] != 0) {
                queue.add(new int[]{i+1, j, block+1});
                visited[i+1][j]= true;
            }

            if (j-1 >= 0 && !visited[i][j-1] && maze[i][j-1] != 0) {
                queue.add(new int[]{i, j-1, block+1});
                visited[i][j-1] = true;
            }

            if (j+1 < M && !visited[i][j+1] && maze[i][j+1] != 0) {
                queue.add(new int[]{i, j+1, block+1});
                visited[i][j+1] = true;
            }
        }

        System.out.println(result);
    }
}