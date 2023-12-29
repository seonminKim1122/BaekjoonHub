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
            
            int start = 0;
            int end = input.length() - 1;
            
            boolean isPalindrome = true;
            while (start < end) {
            	if (input.charAt(start) != input.charAt(end)) isPalindrome = false;
                start++;
                end--;
            }
            
            answer.append("#").append(test_case).append(" ").append(isPalindrome ? 1 : 0).append("\n");
		}
        
        System.out.println(answer);
	}
}