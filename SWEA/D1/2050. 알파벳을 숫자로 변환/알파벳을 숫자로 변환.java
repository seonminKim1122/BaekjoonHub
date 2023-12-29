import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		String input = sc.next();
        
        int len = input.length();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < len; i++) {
        	char alphabet = input.charAt(i);
            answer.append(alphabet - 'A' + 1).append(" ");
        }
        System.out.println(answer);
	}
}