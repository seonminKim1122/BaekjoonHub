import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int end = sc.nextInt();
        System.out.println(end * (end + 1) / 2);
	}
}