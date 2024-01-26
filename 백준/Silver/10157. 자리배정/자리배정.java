import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        if (K > C * R) {
            System.out.println(0);
            return;
        }

        int[][] concertHall = new int[R][C];

        int value = 1;
        int i = R - 1;
        int j = 0;

        concertHall[i][j] = value++;
        int direction = 0;
        while (value <= C * R) {

            boolean move = false;
            switch (direction) {
                case 0: // 상
                    if (canMove(concertHall, i - 1, j)) {
                        concertHall[--i][j] = value++;
                        move = true;
                    }
                    break;
                case 1: // 우
                    if (canMove(concertHall, i, j + 1)) {
                        concertHall[i][++j] = value++;
                        move = true;
                    }
                    break;
                case 2: // 하
                    if (canMove(concertHall, i + 1, j)) {
                        concertHall[++i][j] = value++;
                        move = true;
                    }
                    break;
                case 3: // 좌
                    if (canMove(concertHall, i, j - 1)) {
                        concertHall[i][--j] = value++;
                        move = true;
                    }
                    break;
            }

            if (!move) {
                direction = (direction + 1) % 4;
            }
        }

        int targetX = R;
        int targetY = 1;
        for (int k = 0; k < R; k++) {
            for (int l = 0; l < C; l++) {
                if (concertHall[k][l] == K) {
                    targetX -= k;
                    targetY += l;
                    break;
                }
            }
        }

        System.out.println(targetY + " " + targetX);
    }

    public static boolean canMove(int[][] concertHall, int i, int j) {
        if (i < 0 || j < 0 || i >= concertHall.length || j >= concertHall[0].length) return false;
        if (concertHall[i][j] != 0) return false;

        return true;
    }
}