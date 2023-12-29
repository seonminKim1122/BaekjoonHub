import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 5; i++) {
        	for (int j = 0; j < 5; j++) {
            	if (i == j) answer.append("#");
                else answer.append("+");
            }
            answer.append("\n");
        }
        
        System.out.println(answer);
	}
}