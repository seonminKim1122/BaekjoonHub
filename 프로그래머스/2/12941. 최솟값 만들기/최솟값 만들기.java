import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        
        for (int i = 0; i < A.length; i++) {
            int num1 = A[i];
            int num2 = B[B.length - 1 - i];
            answer += (num1 * num2);
        }

        return answer;
    }
}