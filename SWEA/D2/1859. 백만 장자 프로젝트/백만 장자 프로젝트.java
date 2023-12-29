import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        StringBuilder answer = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer.append("#").append(test_case).append(" ");
            
            int N = sc.nextInt();
            
            int[] prices = new int[N];
            for (int i = 0; i < N; i++) {
            	prices[i] = sc.nextInt();
            }
            
            long profit = 0;
            int sell = prices[N - 1];
            
            for (int i = N - 2; i >= 0; i--) {
            	if (prices[i] <= sell) {
                	profit += (sell - prices[i]);
                } else {
                    sell = prices[i];
                }
            }
            
            answer.append(profit).append("\n");
		}
        
        System.out.println(answer);
	}
}