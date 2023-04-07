import java.util.Arrays;

class Solution {
    public long solution(long n) {
        String s = String.valueOf(n);
        String[] numbers = s.split("");
        Arrays.sort(numbers);

        long answer = 0;
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            answer += Math.pow(10, i) * Integer.parseInt(numbers[i]);
        }
        return answer;
    }
}