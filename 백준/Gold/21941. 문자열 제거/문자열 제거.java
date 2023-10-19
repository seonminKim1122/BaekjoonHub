import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int M = Integer.parseInt(br.readLine());

        String[] strings = new String[M];
        int[] points = new int[M];
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            strings[i] = input[0];
            points[i] = Integer.parseInt(input[1]);
        }

        /*
        strings : abc xyz
        points : 10 5
         */

        int[] dp = new int[S.length() + 1];

        for (int i = 1; i <= S.length(); i++) {
            char character = S.charAt(i - 1);

            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < M; j++) {
                String A = strings[j];

                if (character == A.charAt(A.length() - 1) && S.startsWith(A, i - A.length())) {
                    dp[i] = Math.max(dp[i], dp[i - A.length()] + points[j]);
                }
            }
        }

        System.out.println(dp[S.length()]);
    }
}