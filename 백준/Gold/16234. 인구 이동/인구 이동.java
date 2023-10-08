import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Main { // 예제 다 맞는데 1프로에서 틀린다...

    static int N;
    static int L;
    static int R;
    static List<int[]> group;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int[][] populations = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                populations[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*
        국경선이 open 되는 그룹끼리 묶고,
        각 그룹의 인구 수가 모두 동일하다면 인구 이동 X
        동일하지 않다면 인구 이동 O
         */

        int day = 0;
        while (true) {
            boolean isMove = false;

            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        group = new ArrayList<>();
                        int groupPopulation = bfs(i, j, populations, visited);
                        if (move(populations, groupPopulation)) {
                            isMove = true;
                        }
                    }
                }
            }

            if (!isMove) break;
            day++;
        }

        System.out.println(day);
    }

    public static int bfs(int i, int j, int[][] populations, boolean[][] visited) {
        int sum = 0;
        int cnt = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        group.add(new int[]{i, j});
        visited[i][j] = true;
        sum += populations[i][j];
        cnt++;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

                int diff = Math.abs(populations[x][y] - populations[nx][ny]);
                if (diff < L || diff > R) continue;

                queue.add(new int[]{nx, ny});
                group.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                sum += populations[nx][ny];
                cnt++;
            }
        }

        return sum / cnt;
    }

    public static boolean move(int[][] populations, int groupPopulation) {
        boolean isMoved = false;

        int L = group.size();

        for (int i = 0; i < L; i++) {
            int[] temp = group.get(i);
            int x = temp[0];
            int y = temp[1];

            if (populations[x][y] != groupPopulation) {
                populations[x][y] = groupPopulation;
                isMoved = true;
            }
        }

        return isMoved;
    }
}