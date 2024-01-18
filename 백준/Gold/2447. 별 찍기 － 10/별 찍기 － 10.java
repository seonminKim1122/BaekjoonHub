import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] arr;

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        star(0, 0, N);

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != '*') {
                    answer.append(' ');
                } else {
                    answer.append(arr[i][j]);
                }
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }

    public static void star(int i, int j, int N) {
        if (N == 3) {
            arr[i][j] = arr[i][j + 1] = arr[i][j + 2] = '*';
            arr[i + 1][j] = arr[i + 1][j + 2] = '*';
            arr[i + 2][j] = arr[i + 2][j + 1] = arr[i + 2][j + 2] = '*';
            return;
        }

        star(i, j, N / 3);
        star(i, j + N / 3, N / 3);
        star(i, j + 2 * (N / 3), N / 3);

        star(i + N / 3, j, N / 3);
        star(i + N / 3, j + 2 * (N / 3), N / 3);

        star(i + 2 * (N / 3), j, N / 3);
        star(i + 2 * (N / 3), j + N / 3, N / 3);
        star(i + 2 * (N / 3), j + 2 * (N / 3), N / 3);
    }
}
/*
단순 재귀 -> 시간 초과
 */