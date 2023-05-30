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
        int B = Integer.parseInt(st.nextToken());

        int[][] ground = new int[N][M];
        int min = 256;
        int max = 0;
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(temp[j]);
                if (min > ground[i][j]) {
                    min = ground[i][j];
                }
                if (max < ground[i][j]) {
                    max = ground[i][j];
                }
            }
        }

        /*
        min ~ max 의 높이로 만들기 위해 필요한 시간 중 최소값 출력,
        만약 최소값이 여러 개라면 그 중 땅의 높이가 가장 높은 것 출력
         */

        int height = 0;
        int resultTime = Integer.MAX_VALUE;

        for (int i = min; i <= max; i++) {
            int time = 0;
            int block = B;
            boolean isDone = true;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (ground[j][k] > i) {
                        time += (ground[j][k] - i) * 2;
                        block += (ground[j][k] - i);
                    } else if (ground[j][k] < i) {
                        time += (i - ground[j][k]);
                        block -= (i - ground[j][k]);
                    }
                }
            }

            if (block < 0) {
                isDone = false;
            }

            if (isDone && (time <= resultTime)) {
                resultTime = time;
                height = i;
            }
        }

        System.out.println(resultTime + " " + height);
    }
}