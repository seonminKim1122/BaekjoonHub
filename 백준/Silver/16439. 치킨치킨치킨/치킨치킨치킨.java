import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] preferences = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                preferences[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 한 사람의 만족도는 시킨 치킨 중에서 선호도가 가장 큰 값으로 결정됩니다.
        int max = 0;
        for (int i = 0; i < M-2; i++) {
            for (int j = i+1; j < M-1; j++) {
                for (int k = j+1; k < M; k++) {
                    int result = 0;
                    for (int l = 0; l < N; l++) {
                        result += Math.max(Math.max(preferences[l][i], preferences[l][j]), preferences[l][k]);
                    }
                    if (result > max) {
                        max = result;
                    }
                }
            }
        }

        System.out.println(max);

    }
}