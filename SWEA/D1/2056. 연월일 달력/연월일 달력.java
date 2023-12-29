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
			String date = sc.next();
            
            answer.append("#").append(test_case).append(" ");
            if (isValid(date)) {
                answer.append(date.substring(0, 4)).append("/").append(date.substring(4, 6)).append("/").append(date.substring(6, 8));
            } else {
                answer.append(-1);
            }
            answer.append("\n");
		}
        
        System.out.println(answer);
	}
    
    public static boolean isValid(String date) {
    	int month = Integer.parseInt(date.substring(4, 6));
        int day = Integer.parseInt(date.substring(6, 8));
        
        if (month < 1 || month > 12) return false;
        if (day < 1 || day > 31) return false;
        
        if (month == 2) {
            return !(day > 28);
        }
        
        return !(day > 30);
    }
}