import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int order = 0;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(2, N);

        visit(0, 0, size - 1, size - 1, r, c);

        System.out.println(answer);
    }

    private static void visit(int startY, int startX, int endY, int endX, int targetY, int targetX) {
        // 탐색하는 범위에 targetX 가 포함되어 있지 않으면 그 size 만큼 order 를 늘려주고 굳이 탐색 X
        if (startY > targetY || endY < targetY || startX > targetX || endX < targetX) {
            order += (endY - startY + 1) * (endX - startX + 1);
            return;
        }

        if (startY == targetY && startX == targetX) {
            answer = order;
            return;
        }

        int midY = startY + (endY - startY) / 2;
        int midX = startX + (endX - startX) / 2;

        // 좌상단
        visit(startY, startX, midY, midX, targetY, targetX);

        // 우상단
        visit(startY, midX + 1, midY, endX, targetY, targetX);

        // 좌하단
        visit(midY + 1, startX, endY, midX, targetY, targetX);

        // 우하단
        visit(midY + 1, midX + 1, endY, endX, targetY, targetX);
    }
}