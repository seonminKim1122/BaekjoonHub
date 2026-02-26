import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N][M];
        int count0 = 0;
        int count1 = 0;

        // 1. 입력 받으면서 0, 1 개수 세기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 0) count0++;
                else count1++;
            }
        }

        // 2. 기본 조건: 0과 1의 개수가 각각 짝수여야 함
        if (count0 % 2 != 0 || count1 % 2 != 0) {
            System.out.println(-1);
            return;
        }

        // 3. 인접한 같은 숫자가 하나라도 있는지 체크 (물꼬 트기)
        boolean canStart = false;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        if (grid[i][j] == grid[nx][ny]) {
                            canStart = true;
                            break;
                        }
                    }
                }
                if (canStart) break;
            }
            if (canStart) break;
        }

        // 4. 결과 출력
        if (canStart) {
            System.out.println(1);
        } else {
            System.out.println(-1);
        }
    }
}