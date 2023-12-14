import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int INF = 50;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] relations = new char[N][N];
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                relations[i][j] = input.charAt(j);
                if (relations[i][j] == 'Y') {
                    dist[i][j] = 1;
                } else {
                    dist[i][j] = INF;
                }
            }
            dist[i][i] = 0;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int numOf2Friends = -1;
            for (int j = 0; j < N; j++) {
                if (dist[i][j] <= 2) numOf2Friends++;
            }
            answer = Math.max(answer, numOf2Friends);
        }

        System.out.println(answer);
    }
}