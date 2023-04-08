class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int gcd = GCD(n, m);
        answer[0] = gcd;
        answer[1] = gcd * (n / gcd) * (m / gcd);
        
        return answer;
    }
    
    public int GCD(int n, int m) {
        if (m % n == 0) {
            return n;
        }
        return GCD(m % n, n);
    }
}