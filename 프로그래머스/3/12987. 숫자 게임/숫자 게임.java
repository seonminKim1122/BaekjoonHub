import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        
        int aIdx = 0;
        int bIdx = 0;
        int N = A.length;
        
        while (bIdx < N) {
            if (A[aIdx] < B[bIdx]) {
                answer++;
                aIdx++;
                bIdx++;
            } else {
                bIdx++;
            }
        }
        
        return answer;
    }
}
/*
1 3 5 7
2 2 6 8
*/