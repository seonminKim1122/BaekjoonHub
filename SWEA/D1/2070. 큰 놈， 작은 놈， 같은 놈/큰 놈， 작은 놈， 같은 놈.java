import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		StringBuilder answer = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            
            answer.append("#").append(test_case).append(" ");
            if (num1 < num2) {
                answer.append("<");
            } else if (num1 > num2) {
                answer.append(">");
            } else {
                answer.append("=");
            }
            answer.append("\n");
		}
        System.out.println(answer);
	}
}