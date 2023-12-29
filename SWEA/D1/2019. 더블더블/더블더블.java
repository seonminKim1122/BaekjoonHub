import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
        int N = sc.nextInt();
		StringBuilder answer = new StringBuilder();
        
        int num = 1;
        for (int i = 0; i <= N; i++) {
            answer.append(num).append(" ");
            num *= 2;
        }
        
        System.out.println(answer);
        
	}
}