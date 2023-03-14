import java.io.*;
import java.util.*;

public class Main {

    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dp[0][0][0] = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            bw.write("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) { // IndexOutArray인 Case + 0/0/0 Case
            return dp[0][0][0];
        } else if (a > 20 || b > 20 || c > 20) { // IndexOutArray Case 2
            return w(20, 20, 20);
        } else {
            if (dp[a][b][c] > 0) { // 이미 계산된 값 존재할 때
                return dp[a][b][c];
            } else { // 계산된 값이 존재하지 않을 때
                if (a < b && b < c) {
                    dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
                } else {
                    dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
                }
                return dp[a][b][c];
            }
        }
    }
}