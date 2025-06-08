import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 세로
        int M = Integer.parseInt(st.nextToken());   // 가로
        int B = Integer.parseInt(st.nextToken());   // 인벤토리 내 블록 수

        int[][] land = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가장 높은 높이부터 하나씩 낮춰가면서 맞추기(?)
        // => 500 x 500 x 256
        int minTime = Integer.MAX_VALUE;
        int maxHeight = 0;
        for (int H = 256; H >= 0; H--) {
            int need = 0; // 모든 높이를 H로 만들기 위해 필요한 추가 블록 수
            int time = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (land[i][j] < H) {
                        need += (H - land[i][j]);
                        time += (H - land[i][j]);
                    } else if (land[i][j] > H) {
                        need -= (land[i][j] - H);
                        time += 2 * (land[i][j] - H);
                    }
                }
            }

            if (need > B) continue;

            if (minTime > time) {
                minTime = time;
                maxHeight = H;
            } else if (minTime == time) {
                maxHeight = Math.max(maxHeight, H);
            }
        }

        System.out.println(minTime + " " + maxHeight);
    }
}