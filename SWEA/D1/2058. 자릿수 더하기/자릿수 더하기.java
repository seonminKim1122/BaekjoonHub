import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		String[] numbers = br.readLine().split("");
        int len = numbers.length;
        
        int answer = 0;
        for (int i = 0; i < len; i++) {
        	answer += Integer.parseInt(numbers[i]);
        }
        
        System.out.println(answer);
	}
}