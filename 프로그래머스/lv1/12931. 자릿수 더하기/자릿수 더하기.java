import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int divisor = 10;
        while ((n % divisor) != n) {
            answer += ((n % divisor) - (n % (divisor/10)))/(divisor/10);
            divisor *= 10;
        }
        answer += ((n % divisor) - (n % (divisor/10)))/(divisor/10);
        return answer;
    }
}