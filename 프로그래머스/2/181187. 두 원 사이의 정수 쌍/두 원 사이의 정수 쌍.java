class Solution {
    public long solution(int intR1, int intR2) {
        long answer = 0;
        
        long r1 = (long)intR1;
        long r2 = (long)intR2;
        
        // 0 < x < r1 && -r1 < x < 0
        for (long x = 1; x < r1; x++) {
            long low = (long)Math.ceil(Math.sqrt(r1 * r1 - x * x));
            long high = (long)Math.floor(Math.sqrt(r2 * r2 - x * x));
            
            answer += 2 * (2 * (high - low + 1));
        }
        
        // r1 <= x < r2 && -r2 < x <= -r1
        for (long x = r1; x < r2; x++) {
            answer += 2 * (2 * (long)Math.floor(Math.sqrt(r2 * r2 - x * x)) + 1);
        }
        
        // x = r2 && x = -r2
        answer += 2;
        
        // x = 0 일 때
        answer += 2 * (r2 - r1 + 1);
        
        return answer;
    }
}

/*
어디가 틀렸을까...?
*/