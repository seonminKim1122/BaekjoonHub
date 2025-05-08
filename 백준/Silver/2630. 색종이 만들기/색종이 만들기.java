import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] square = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] answer = solve(square, N);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    private static int[] solve(int[][] square, int N) {
        int[] result = new int[2];
        recursive(square, 0, 0, N, N, result);
        return result;
    }

    private static void recursive(int[][] square, int startX, int startY, int endX, int endY, int[] result) {

        if (isSameColor(square, startX, startY, endX, endY)) {
            result[square[startX][startY]]++;
        } else {
            int midX = startX + (endX - startX) / 2;
            int midY = startY + (endY - startY) / 2;
            // I
            recursive(square, startX, startY, midX, midY, result);

            // II
            recursive(square, startX, midY, midX, endY, result);

            // III
            recursive(square, midX, startY, endX, midY, result);

            // IV
            recursive(square, midX, midY, endX, endY, result);
        }
    }

    private static boolean isSameColor(int[][] square, int startX, int startY, int endX, int endY) {
        int criteria = square[startX][startY];

        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                if (square[i][j] != criteria) return false;
            }
        }

        return true;
    }
}