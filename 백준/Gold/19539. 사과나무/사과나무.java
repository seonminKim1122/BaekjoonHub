import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 사과나무 개수
        StringTokenizer st = new StringTokenizer(br.readLine());

        int totalHeight = 0;
        int cntOfSize2 = 0;
        for (int i = 1; i <= N; i++) {
            int appleTree = Integer.parseInt(st.nextToken());
            totalHeight += appleTree;
            cntOfSize2 += (appleTree / 2);
        }

        if (totalHeight % 3 != 0) {
            System.out.println("NO");
        } else {
            System.out.println(cntOfSize2 >= (totalHeight / 3) ? "YES" : "NO");
        }
    }
}