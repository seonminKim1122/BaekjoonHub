import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String temp = "";
        while(n > 0) {
            temp += (n % 3);
            n /= 3;
        }

        answer = Integer.parseInt(temp, 3);
        return answer;
    }
}