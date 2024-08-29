class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        long max = d / k;
        long D = (long)d;
        long distance = D * D;
        
        long a = 0;
        while (a <= max) {
            answer += (int)(Math.sqrt((d + a * k) * (d - a * k)) / (double)k) + 1;
            a++;
        }
        
        return answer;
    }
}