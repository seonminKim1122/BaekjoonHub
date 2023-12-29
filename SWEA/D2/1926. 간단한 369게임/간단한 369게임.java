import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		
        int N = sc.nextInt();
        StringBuilder answer = new StringBuilder();
        for (int num = 1; num <= N; num++) {
        	int cnt = cntOf369(num);
            
            if (cnt != 0) {
                for (int i = 0; i < cnt; i++) {
                	answer.append("-");
                }
            } else {
            	answer.append(num);
            }
            answer.append(" ");
        }
        
        System.out.println(answer);
	}
    
    public static int cntOf369(int num) {
        
        String strNum = String.valueOf(num);
        int len = strNum.length();
        
        int result = 0;
        for (int i = 0; i < len; i++) {
        	char n = strNum.charAt(i);
            if (n == '3' || n == '6' || n =='9') result++;
        }
        
    	return result;
    }
}