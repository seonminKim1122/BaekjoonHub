import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 정점의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point(Integer.parseInt(st.nextToken()), i);
        }

        Arrays.sort(points);

        int[] suppressed = new int[N];
        for (int i = 1; i < N; i++) {
            if (points[i].value == points[i - 1].value) {
                suppressed[points[i].index] = suppressed[points[i - 1].index];
            } else {
                suppressed[points[i].index] = suppressed[points[i - 1].index] + 1;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            answer.append(suppressed[i]).append(" ");
        }

        System.out.println(answer);
    }

    static class Point implements Comparable<Point> {
        int value;
        int index;

        Point(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int compareTo(Point other) {
            return this.value - other.value;
        }
    }
}