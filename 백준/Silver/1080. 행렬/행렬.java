import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] A;
    static int[][] B;

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
               A[i][j] = temp.charAt(j) - '0';
            }
        }

        B = new int[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                B[i][j] = temp.charAt(j) - '0';
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) {
                    flip(i, j);
                    cnt++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) {
                    cnt = -1;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }

    public static void flip(int i, int j) {
        if (i + 2 >= N || j + 2 >= M) return;

        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                A[k][l] = (A[k][l] + 1) % 2;
            }
        }
    }
}