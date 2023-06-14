import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int len = (int)Math.pow(2, N);
        conquer2(r, c, N);
        System.out.println(result);
    }
    
    // r행 c열이 어느 사분면에 속하는지를 통해 정복 시간을 단축해보자
    public static void conquer2(int r, int c, int N) {
        if (N == 0) {
            return;
        }
        int size = (int)Math.pow(2, N);
        int add = size * size / 4;
        // 1사분면
        if (r < size/2 && c < size/2) {
            conquer2(r, c, N-1);
        } else if (r < size/2 && c >= size/2) {
            result += add;
            conquer2(r, c - size/2, N-1);
        } else if (r >= size/2 && c < size/2) {
            result += (2 * add);
            conquer2(r - size/2, c, N-1);
        } else {
            result += (3 * add);
            conquer2(r - size/2, c - size/2, N-1);
        }
    }
}