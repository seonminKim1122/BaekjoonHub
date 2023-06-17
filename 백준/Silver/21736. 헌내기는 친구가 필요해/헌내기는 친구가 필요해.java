import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] campus = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> people = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                if(temp[j].equals("X")) {
                    campus[i][j] = 0;
                } else {
                    campus[i][j] = 1;
                    if (temp[j].equals("P")) {
                        people.add(new int[]{i, j});
                    } else if (temp[j].equals("I")) {
                        queue.add(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        while (!queue.isEmpty()) {
            int[] temp = queue.remove();

            for (int i = 0; i < 4; i++) {
                int x = temp[0] + dx[i];
                int y = temp[1] + dy[i];

                if (x < 0 || y < 0 || x >= N || y >= M || visited[x][y] || campus[x][y] == 0) continue;

                queue.add(new int[]{x, y});
                visited[x][y] = true;
            }
        }

        int result = 0;
        while (!people.isEmpty()) {
            int[] xy = people.remove();
            if (visited[xy[0]][xy[1]]) {
                result++;
            }
        }

        if (result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }
    }
}