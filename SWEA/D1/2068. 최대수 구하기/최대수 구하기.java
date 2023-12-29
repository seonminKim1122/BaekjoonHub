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
			int max = -1;
            for (int i = 0; i < 10; i++) {
            	max = Math.max(max, sc.nextInt());
            }

			answer.append("#").append(test_case).append(" ").append(max).append("\n");
		}
        
        System.out.println(answer);
	}
}