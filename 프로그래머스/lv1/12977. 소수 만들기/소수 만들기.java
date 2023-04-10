class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                for (int k = j+1; k < length; k++) {
                    if(isPrime(nums[i] + nums[j] + nums[k])) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
    
    public boolean isPrime(int n) {
        double sqrt = Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}