import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] numbers;
    static boolean[][] visited;

    static int N;
    static int M;

    static int result = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String number = br.readLine();
            for (int j = 0; j < M; j++) {
                numbers[i][j] = number.charAt(j) - '0';
            }
        }

        dfs(0, 0);

        System.out.println(result);
    }
    
    public static void dfs(int i, int j) {
        if (i == N) {
            caculator();
            return;
        }

        if (j == M) { // 더 이상 가로로 못 감 -> 다음 라인 true, false 하러 이동
            dfs(i + 1, 0);
            return;
        }

        visited[i][j] = true;
        dfs(i, j + 1);

        visited[i][j] = false;
        dfs(i, j + 1);
    }

    public static void caculator() {
        int sum = 0;

        for (int i = 0; i < N; i++) {
            int temp = 0;
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    temp = temp * 10 + numbers[i][j];
                } else {
                    sum += temp;
                    temp = 0;
                }
            }
            sum += temp;
        }

        for (int i = 0; i < M; i++) {
            int temp = 0;
            for (int j = 0; j < N; j++) {
                if (!visited[j][i]) {
                    temp = temp * 10 + numbers[j][i];
                } else {
                    sum += temp;
                    temp = 0;
                }
            }
            sum += temp;
        }

        result = Math.max(result, sum);
    }
}