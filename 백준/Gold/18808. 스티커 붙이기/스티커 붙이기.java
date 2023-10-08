import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] notebook = new int[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int[][] sticker = new int[R][C];
            for (int j = 0; j < R; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < C; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int t = 0; t < 4; t++) {
                if (t != 0) {
                    sticker = rotate(sticker);
                }

                int[] result = canAttach(notebook, sticker);
                if (result[0] == 1) {
                    attach(notebook, sticker, result[1], result[2]);
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    public static int[] canAttach(int[][] notebook, int[][] sticker) {
        // 붙일 수 있으면 return {1, i, j}
        // 붙일 수 없으면 return {0, -1, -1}
        int R = sticker.length;
        int C = sticker[0].length;

        int N = notebook.length;
        int M = notebook[0].length;

        for (int i = 0; i <= N - R; i++) {
            for (int j = 0; j <= M - C; j++) {

                boolean temp = true;
                loop : for (int k = 0; k < R; k++) {
                    for (int l = 0; l < C; l++) {
                        if (sticker[k][l] == 1 && notebook[i + k][j + l] == 1) {
                            temp = false;
                            break loop;
                        }
                    }
                }

                if (temp) {
                    return new int[]{1, i, j};
                }

            }
        }

        return new int[]{0, -1, -1};
    }

    public static void attach(int[][] notebook, int[][] sticker, int i, int j) {
        int R = sticker.length;
        int C = sticker[0].length;

        for (int k = i; k < i + R; k++) {
            for (int l = j; l < j + C; l++) {
                if (sticker[k - i][l - j] == 1 && notebook[k][l] == 0) {
                    notebook[k][l] = sticker[k - i][l - j];
                    answer++;
                }
            }
        }
    }

    public static int[][] rotate(int[][] sticker) {
        int R = sticker.length;
        int C = sticker[0].length;

        int[][] result = new int[C][R];

        for (int i = 0; i < C; i++) {
            for (int j = R - 1; j >= 0; j--) {
                result[i][(R - 1) - j] = sticker[j][i];
            }
        }

        return result;
    }
}