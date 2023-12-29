import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		
        String strNum = sc.next();
        
        int result = 0;
        int len = strNum.length();
        
        for (int i = 0; i < len; i++) {
        	result += (strNum.charAt(i) - '0');
        }
        
        System.out.println(result);
	}
}