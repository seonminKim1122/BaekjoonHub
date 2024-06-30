import java.util.*;

class Solution {
    
    static int answer = 0;
    static Set<Integer> visit = new HashSet<>();
    
    public int solution(String numbers) {
        boolean[] used = new boolean[numbers.length()];
        solve(numbers, 0, used, 0);       
        return answer;
    }
    
    public void solve(String numbers, int number, boolean[] used, int depth) {
        if (isPrime(number) && !visit.contains(number)) {
            answer++;
            visit.add(number);
        }
        
        if (depth == numbers.length()) {
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (used[i]) continue;
            used[i] = true;
            solve(numbers, number * 10 + (numbers.charAt(i) - '0'), used, depth + 1);
            used[i] = false;
        }
    }
    
    public boolean isPrime(int number) {
        if (number < 2) return false;
        
        int sqrt = (int)Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) return false;
        }
        
        return true;
    }
}