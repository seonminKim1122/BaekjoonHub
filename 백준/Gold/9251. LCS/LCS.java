import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int N = s1.length();
        int M = s2.length();

        int[][] LCS = new int[N][M];
        if (s1.charAt(0) == s2.charAt(0)) {
            LCS[0][0] = 1;
        }

        for (int i = 1; i < N; i++) {
            LCS[i][0] = LCS[i - 1][0];
            if (s1.charAt(i) == s2.charAt(0)) {
                LCS[i][0] = 1;
            }
        }
        for (int j = 1; j < M; j++) {
            LCS[0][j] = LCS[0][j - 1];
            if (s2.charAt(j) == s1.charAt(0)) {
                LCS[0][j] = 1;
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                if (s1.charAt(i) == s2.charAt(j)) {
                    LCS[i][j] = Math.max(LCS[i][j], LCS[i - 1][j - 1] + 1);
                }
            }
        }

        System.out.println(LCS[N - 1][M - 1]);
    }
}