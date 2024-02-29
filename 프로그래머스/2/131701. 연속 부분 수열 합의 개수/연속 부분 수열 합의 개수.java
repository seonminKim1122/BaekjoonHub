import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int N = elements.length;
        int[] temp = new int[2 * N];
        for (int i = 0; i < N; i++) {
            temp[i] = elements[i];
            temp[i + N] = elements[i];
        }
        
        int[] S = new int[2 * N + 1];
        S[0] = 0;
        for (int i = 1; i <= 2 * N; i++) {
            S[i] = S[i - 1] + temp[i - 1];
        }
        
        Set<Integer> set = new HashSet<>();
        for (int size = 1; size <= N; size++) {
            for (int i = size; i <= N + size; i++) {
                set.add(S[i] - S[i - size]);
            }
        }
        
        answer = set.size();
        return answer;
    }
}