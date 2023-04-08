class Solution {
    public boolean solution(int x) {
        int idx = 0;
        int n = x;
        while (x > 0) { // 6311
            idx += (x % 10); // 1의 자리
            x = x / 10; // 10 의자리

        }
        
        if (n % idx == 0) {
            return true;
        } else {
            return false;
        }
    }
}