import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int M = sc.nextInt();
            
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
            	for (int j = 0; j < N; j++) {
                	arr[i][j] = sc.nextInt();
                }
            }
            
            int result = 0;
            for (int i = 0; i <= N - M; i++) {
            	for (int j = 0; j <= N - M; j++) {
                	result = Math.max(result, cntOfDeadFlies(arr, i, j, M));
                }
            }
            
            System.out.println("#" + test_case + " " + result);
		}
	}
    
    public static int cntOfDeadFlies(int[][] arr, int i, int j, int M) {
    	int result = 0;
        for (int h = i; h < i + M; h++) {
        	for (int w = j; w < j + M; w++) {
            	result += arr[h][w];
            }
        }
        
        return result;
    }
}