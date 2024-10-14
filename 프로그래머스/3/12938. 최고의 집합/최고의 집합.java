import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (s / n == 0) return new int[]{-1};
        
        int[] answer = new int[n];
        if (s % n == 0) {
            Arrays.fill(answer, s / n);
        } else {
            int temp = s % n;
            for (int i = 0; i < n - temp; i++) {
                answer[i] = (s / n);
            }
            for (int i = n - temp; i < n; i++) {
                answer[i] = (s / n) + 1;
            }
        }
        
        return answer;
    }
}
/*
만약 s % n == 0 이라면
s / n 로 전부 채우는 게 best

그게 아닌 경우

s % n 개는 (s / n) + 1, 나머지는 s / n 으로 채우는 게 best
if (s / n == 0) 인 경우 자연수가 아니므로 불가능
*/