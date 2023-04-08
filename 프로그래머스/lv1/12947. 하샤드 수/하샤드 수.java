class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String num = String.valueOf(x);
        int divisor = 0;

        for(String n : num.split("")) {
            divisor += Integer.parseInt(n);
        }

        if ( x % divisor != 0) answer = false;
        return answer;
    }
}