import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 연결요소의 갯수를 구하는 문제
    // 그래프를 어떻게 만들 것인가?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            boolean[][] cabbageField = new boolean[N][M];
            boolean[][] visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                StringTokenizer xy = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(xy.nextToken());
                int y = Integer.parseInt(xy.nextToken());

                cabbageField[y][x] = true;
            }

            int result = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (cabbageField[j][k] && !visited[j][k]) {
                        dfs(j, k, cabbageField, visited);
                        result++;
                    }
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int y, int x, boolean[][] cabbageField, boolean[][] visited) {
        visited[y][x] = true;

        int lenOfX = cabbageField[y].length;
        for (int i = x+1; i < lenOfX; i++) {
            if (cabbageField[y][i] && !visited[y][i]) {
                dfs(y, i, cabbageField, visited);
            } else {
                break;
            }
        }

        for (int i = x-1; i >= 0; i--) {
            if (cabbageField[y][i] && !visited[y][i]) {
                dfs(y, i, cabbageField, visited);
            } else {
                break;
            }
        }

        int lenOfY = cabbageField.length;
        for (int i = y+1; i < lenOfY; i++) {
            if (cabbageField[i][x] && !visited[i][x]) {
                dfs(i, x, cabbageField, visited);
            } else {
                break;
            }
        }

        for (int i = y-1; i >= 0; i--) {
            if (cabbageField[i][x] && !visited[i][x]) {
                dfs(i, x, cabbageField, visited);
            } else {
                break;
            }
        }
    }
}