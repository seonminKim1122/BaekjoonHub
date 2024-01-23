import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {


    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String seq1 = br.readLine();
        String seq2 = br.readLine();

        int R = seq1.length();
        int C = seq2.length();

        int[][] dp = new int[R + 1][C + 1];
        int result = 0;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (seq1.charAt(i - 1) == seq2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    if (dp[i - 1][j] < dp[i][j - 1]) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        int r = seq1.length();
        int c = seq2.length();

        Stack<Character> temp = new Stack<>();
        while (r >= 1 && c >= 1) {
            if (dp[r][c] == dp[r][c - 1]) {
                c--;
            } else if (dp[r][c] == dp[r - 1][c]) {
                r--;
            } else {
                temp.push(seq1.charAt(r - 1));
                r--;
                c--;
            }
        }

        StringBuilder answer = new StringBuilder();
        while (!temp.isEmpty()) {
            answer.append(temp.pop());
        }

        System.out.println(answer.length());
        System.out.println(answer);
    }
}
/*
LCS 의 길이는 위처럼 구하면 되는데 실제 부분 수열은 어떻게 구할 것인가?

dp[i][j] 의 값이 어떤가를 생각해보자
  A C A Y K P
C
A
P
C
A
K

끝에서부터 시작해서 Stack 에 넣고 마지막에 빼면 원하는 값이 나올 수 있다.

str1 = CAPCAK
str2 = ACAYKP
dp[i][j] == dp[i - 1][j] 이면
-> str1[i] 는 부분수열에 포함되지 않는다는 의미
dp[i][j] == dp[i][j - 1]
-> str2[j] 는 부분수열에 포함되지 않는다는 의미

둘다 아니면?
 */