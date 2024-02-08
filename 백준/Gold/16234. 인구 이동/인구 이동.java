import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int populationSum;
    static int cnt;
    static int[][] populations;
    static int N;
    static int L;
    static int R;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<int[]> union;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        populations = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                populations[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while (true) {
            boolean[][] isUnion = new boolean[N][N];
            int movedCnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!isUnion[i][j]) {
                        union = new ArrayList<>();
                        populationSum = 0;
                        cnt = 0;

                        dfs(i, j, isUnion);
                        movedCnt += move();
                    }
                }
            }
            
            // 인구 이동
            if (movedCnt == 0) break;
            day++;
        }

        System.out.println(day);
    }

    static void dfs(int i, int j, boolean[][] isUnion) {
        isUnion[i][j] = true;
        cnt++;
        populationSum += populations[i][j];
        union.add(new int[]{i, j});

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (isUnion[nx][ny]) continue;
            
            int diff = Math.abs(populations[i][j] - populations[nx][ny]);
            if (diff < L || diff > R) continue;

            dfs(nx, ny, isUnion);
        }
    }

    static int move() {
        int value = populationSum / cnt;

        int result = 0;
        for (int i = 0; i < union.size(); i++) {
            int[] now = union.get(i);
            if (populations[now[0]][now[1]] != value) {
                populations[now[0]][now[1]] = value;
                result = 1;
            }
        }

        return result;
    }
}