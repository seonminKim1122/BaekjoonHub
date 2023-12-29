import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
        int N = sc.nextInt();
        StringBuilder answer = new StringBuilder();
        for (int i = N; i >= 0; i--) {
        	answer.append(i).append(" ");
        }
        
        System.out.println(answer);
	}
}