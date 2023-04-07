class Solution {
    public long solution(long n) {
        long answer = 0;
        if(Math.sqrt(n) == (int) Math.sqrt(n)) {
            answer = (long) Math.pow(Math.sqrt(n)+1, 2);
        } else {
            answer = -1;
        }

        return answer;
    }
}