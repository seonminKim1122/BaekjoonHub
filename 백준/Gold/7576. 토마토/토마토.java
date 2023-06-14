import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 가로
        int N = Integer.parseInt(st.nextToken()); // 세로

        int[][] tomatos = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatos[i][j] = Integer.parseInt(temp.nextToken());
                if (tomatos[i][j] == 1) {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }

        int result = 0;
        while (!queue.isEmpty()) {
            int i = queue.peek()[0];
            int j = queue.peek()[1];
            int depth = queue.peek()[2];
            
            if (check(i, j-1, tomatos)) { // 상
                tomatos[i][j-1] = 1;
                queue.add(new int[]{i, j-1, depth+1});
            }

            if (check(i, j+1, tomatos)) { // 하
                tomatos[i][j+1] = 1;
                queue.add(new int[]{i, j+1, depth+1});
            }

            if (check(i-1, j, tomatos)) { // 좌
                tomatos[i-1][j] = 1;
                queue.add(new int[]{i-1, j, depth+1});
            }

            if (check(i+1, j, tomatos)) { // 우
                tomatos[i+1][j] = 1;
                queue.add(new int[]{i+1, j, depth+1});
            }
            queue.remove();
            result = depth;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatos[i][j] == 0) {
                    result = -1;
                    break;
                }
            }
        }

        System.out.println(result);
    }

    public static boolean check(int i, int j, int[][] tomatos) {
        if (i < 0 || i >= tomatos.length || j < 0 || j >= tomatos[0].length) {
            return false;
        }

        if (tomatos[i][j] == 0) {
            return true;
        }

        return false;
    }
}