import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] grades = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                grades[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][2];
        dp[0][0] = dp[0][1] = 1;

        int cnt = dp[0][0];
        int grade = Math.min(grades[0][0], grades[0][1]);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = 1;

                if (grades[i][j] == grades[i - 1][0]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][0] + 1);
                }

                if (grades[i][j] == grades[i - 1][1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][1] + 1);
                }

                if (cnt < dp[i][j]) {
                    cnt = dp[i][j];
                    grade = grades[i][j];
                } else if (cnt == dp[i][j]) {
                    grade = Math.min(grade, grades[i][j]);
                }
            }
        }

        System.out.println(cnt + " " + grade);
    }
}