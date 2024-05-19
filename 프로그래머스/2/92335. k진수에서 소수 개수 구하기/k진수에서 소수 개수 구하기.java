class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String changed = String.valueOf(changeBase(n, k));
        
        long num = 0;
        for (char ch : changed.toCharArray()) {
            if (ch - '0' == 0) {
                if (isPrime(num)) answer++;
                System.out.println(num);
                num = 0;
                continue;
            }
            num = num * 10 + (ch - '0');
        }
        
        System.out.println(num);
        if (isPrime(num)) answer++;
        
        
        return answer;
    }
    
    long changeBase(int n, int k) {
        // n : 10진수, k : 변환할 진법
        if (n < k) return n % k;
        return changeBase(n / k, k) * 10 + n % k;
    }
    
    boolean isPrime(long num) {
        if (num <= 1) return false;
        
        for (int i = 2; i <= (int)Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
/*

*/