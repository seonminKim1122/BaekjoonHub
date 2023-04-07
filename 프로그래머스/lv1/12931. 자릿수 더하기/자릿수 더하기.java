import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int divisor = 1;
        while ((n % divisor) != n) {
            answer += ((n % (divisor*10)) - (n % divisor)) / divisor;
            divisor *= 10;
        }
        return answer;
    }
}