class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
            int temp = calc(i);
            System.out.print(temp + " ");
            answer += temp > limit ? power : temp;
        }
        
        return answer;
    }
    
    int calc(int number) {
        int result = 0;
        
        int sqrt = (int)Math.sqrt(number);
        for (int i = 1; i <= sqrt; i++) {
            if (number % i == 0) result++;
        }
        result *= 2;
        
        if (sqrt == Math.sqrt(number)) result--;
        return result;
    }
}