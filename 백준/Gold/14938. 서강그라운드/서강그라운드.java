import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 지역의 개수
        int m = Integer.parseInt(st.nextToken()); // 수색범위
        int r = Integer.parseInt(st.nextToken()); // 길의 개수

        int[] items = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 15 * n);
            dist[i][i] = 0;
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int l = Integer.parseInt(st.nextToken());

            dist[a][b] = dist[b][a] = l;
        }

        // 모든 지역 간의 최소 거리를 계산
        calcDistance(dist, n);

        // 각 지역을 낙하 위치로 했을 때 최대로 얻을 수 있는 아이템 갯수 계산
        int answer = 0;
        for (int start = 0; start < n; start++) {
            answer = Math.max(answer, calcGettableItems(dist[start], items, n, m));
        }

        System.out.println(answer);
    }

    static int calcGettableItems(int[] dist, int[] items, int n, int m) {
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (dist[i] <= m) {
                result += items[i];
            }
        }

        return result;
    }

    static void calcDistance(int[][] dist, int n) {

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

    }

}