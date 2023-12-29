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
			String input = sc.next();
			int end = 1;
            String pattern = input.substring(0, end);
            
            while (!pattern.equals(input.substring(end, end + pattern.length()))) {
            	pattern = input.substring(0, ++end);
            }

            answer.append("#").append(test_case).append(" ").append(pattern.length()).append("\n");
		}
        
        System.out.println(answer);
	}
}