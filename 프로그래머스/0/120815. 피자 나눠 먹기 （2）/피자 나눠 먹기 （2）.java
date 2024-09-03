class Solution {
    public int solution(int n) {
        int answer = 0;
        answer = n / GCD(n, 6);
        return answer;
    }
    
    public int GCD(int A, int B) {
        if (B == 0) return A;
        if (A < B) {
            return GCD(B, A);
        }
        return GCD(B, A % B);
    }
}
/*
6 과 n 의 최소 공배수 찾고 6으로 나누면 최소 피자 판수

GCD * (6 / GCD) * (n / GCD) / 6 -> (n / GCD)
*/