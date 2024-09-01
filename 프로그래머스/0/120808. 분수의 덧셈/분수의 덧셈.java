class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        
        int numer = numer1 * denom2 + numer2 * denom1;
        int denom = denom1 * denom2;
        int gcd = GCD(numer, denom);
        
        int[] answer = {numer / gcd, denom / gcd};
        return answer;
    }
    
    int GCD(int A, int B) {
        int min = Math.min(A, B);
        for (int i = min; i > 1; i--) {
            if ((A % i) == 0 && (B % i) == 0) return i;
        }
        return 1;
    }
}