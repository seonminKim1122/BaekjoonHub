class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isPrime(int n) {
        boolean answer = false;
        int cnt = 0;
        double sqrt = Math.sqrt(n);
        
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                cnt++;
                break;
            }
        }
        
        answer = (cnt == 0);
        return answer;
    }
}