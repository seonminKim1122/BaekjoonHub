import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        int[][] dp = new int[11][11];
        dp[0][1] = 1;
        
        for (int i = 1; i <= 10; i++) {
        	for (int j = 1; j <= i; j++) {
            	dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

        StringBuilder answer = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            
            answer.append("#").append(test_case).append("\n");
            for (int i = 1; i <= N; i++) {
            	for (int j = 1; j <= i; j++) {
                    answer.append(dp[i][j]).append(" ");
                }
                answer.append("\n");
            }
		}
        
        System.out.println(answer);
	}
}