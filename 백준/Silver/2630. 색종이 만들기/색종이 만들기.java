import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int white = 0;
    private static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checkAndCut(paper, 0, 0, N-1, N-1);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void checkAndCut(int[][] paper, int startX, int startY, int endX, int endY) {
        int criteria = paper[startX][startY];
        boolean isOkay = true;

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (paper[i][j] != criteria) {
                    isOkay = false;
                    break;
                }
            }
        }

        if (!isOkay) {
            checkAndCut(paper, startX, startY, (startX+endX)/2, (startY+endY)/2);
            checkAndCut(paper, startX, (startY+endY)/2 + 1, (startX+endX)/2, endY);
            checkAndCut(paper, (startX+endX)/2 + 1, startY, endX, (startY+endY)/2);
            checkAndCut(paper, (startX+endX)/2 + 1, (startY+endY)/2 + 1, endX, endY);
        } else {
            if (criteria == 1) {
                blue++;
            } else {
                white++;
            }
        }
    }
}