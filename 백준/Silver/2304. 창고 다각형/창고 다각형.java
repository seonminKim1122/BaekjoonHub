import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //  기둥의 개수

        int highestPoint = -1;
        int highestHeight = -1;

        List<int[]> bars = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            int point = Integer.parseInt(input[0]);
            int height = Integer.parseInt(input[1]);

            if (highestHeight < height) {
                highestPoint = point;
                highestHeight = height;
            }

            bars.add(new int[]{point, height});
        }

        bars.sort((b1, b2) -> b1[0] - b2[0]);

        int idx = 0;
        int lastPoint = bars.get(idx)[0];
        int lastHeight = bars.get(idx)[1];

        int answer = highestHeight;
        while (true) {
            int point = bars.get(idx)[0];
            int height = bars.get(idx)[1];

            if (height >= lastHeight) {
                answer += (lastHeight) * (point - lastPoint);
                lastPoint = point;
                lastHeight = height;
            }

            if (point == highestPoint) break;
            idx++;
        }

        idx = bars.size() - 1;
        lastPoint = bars.get(idx)[0];
        lastHeight = bars.get(idx)[1];

        while (true) {
            int point = bars.get(idx)[0];
            int height = bars.get(idx)[1];

            if (height >= lastHeight) {
                answer += (lastHeight) * (lastPoint - point);
                lastPoint = point;
                lastHeight = height;
            }

            if (point == highestPoint) break;
            idx--;
        }

        System.out.println(answer);
    }
}