import java.util.*;

public class Solution {
    
    public int solution(int n) {
        int ans = 0;
        
        while (n > 0) {
            ans += (n % 2);
            n /= 2;
        }
        
        return ans;
    }
}

/*
5
-> 2, 1(walk)
-> 1, 0
-> 0, 1(walk)
=> 2

6
-> 3, 0
-> 1, 1(walk)
-> 0, 1(walk)

5000
-> 2500, 0
-> 1250, 0
-> 625, 0
-> 312, 1(walk)
-> 156, 0
-> 78, 0
-> 39, 0
-> 19, 1(walk)
-> 9, 1(walk)
-> 4, 1(walk)
-> 2, 0
-> 1, 0
-> 0, 1(walk)

*/
