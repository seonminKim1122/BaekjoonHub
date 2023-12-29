import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
        int N = sc.nextInt();
        
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
        	numbers[i] = sc.nextInt();
        }
        
        Arrays.sort(numbers);
        System.out.println(numbers[N / 2]);
	}
}