import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] numbers;
    static int N;
    static int M;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                numbers[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                for (int d1 = -N; d1 < N; d1++) { // 세로 방향 공차
                    for (int d2 = -M; d2 < M; d2++) { // 가로 방향 공차
                        if (d1 == 0 && d2 == 0) continue;

                        int temp = 0;
                        int r = i;
                        int c = j;

                        while (r >= 0 && r < N && c >= 0 && c < M) {
                            temp = (10 * temp) + numbers[r][c];
                            if (isSquareNumber(temp)) {
                                result = Math.max(result, temp);
                            }

                            r += d1;
                            c += d2;
                        }

                    }
                }

            }
        }

        System.out.println(result);
    }

    public static boolean isSquareNumber(int number) {
        return (int)Math.sqrt(number) == Math.sqrt(number);
    }
}