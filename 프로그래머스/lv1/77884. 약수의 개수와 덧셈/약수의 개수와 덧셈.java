class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int num = left; num <= right; num++) {
            answer += counter(num) % 2 == 0 ? num : num*(-1);
        }
        
        return answer;
    }
    
    public int counter(int n) {
        double sqrt = Math.sqrt(n);
        int count = 0;
        
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                if (i == sqrt) {
                    count += 1;
                } else {
                    count += 2;
                }
            }
        }
        
        return count;
    }
}