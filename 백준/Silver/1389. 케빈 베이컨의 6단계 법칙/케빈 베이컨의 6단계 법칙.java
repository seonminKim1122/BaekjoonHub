import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int INF = 10000;
    static int N;
    static int M;

    static boolean[][] relations;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        relations = new boolean[N][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;

            relations[A][B] = relations[B][A] = true;
        }

        floydWarshall();

        int person = -1;
        int minKevinBacon = INF;

        for (int i = 0; i < N; i++) {
            int kevinBacon = 0;
            for (int j = 0; j < N; j++) {
                kevinBacon += distance[i][j];
            }
            if (kevinBacon < minKevinBacon) {
                person = i;
                minKevinBacon = kevinBacon;
            }
        }

        System.out.println(person + 1);
    }

    public static void floydWarshall() {
        // 거리 배열 초기화
        distance = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (relations[i][j]) distance[i][j] = 1;
                else distance[i][j] = INF;
            }
            distance[i][i] = 0;
        }

        for (int mid = 0; mid < N; mid++) {
            for (int from = 0; from < N; from++) {
                for (int to = 0; to < N; to++) {
                    distance[from][to] = Math.min(distance[from][to], distance[from][mid] + distance[mid][to]);
                }
            }
        }
    }
}