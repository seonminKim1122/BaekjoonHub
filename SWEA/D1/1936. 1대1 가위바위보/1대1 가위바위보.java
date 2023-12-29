import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		
        int diff = sc.nextInt() - sc.nextInt();
        
        if (diff == -2 || diff == 1) System.out.println("A");
        else System.out.println("B");
	}
}