class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < answer.length; i++) {  
            answer[i] = solve(numbers[i]);
        }
        
        return answer;
    }
    
    
    public long solve(long number) {
        if (number % 2 == 0) return number + 1;
        
        long origin = number;
        
        long add = 1;
        long digit = -1;
        while (number > 0) {
            if (number % 2 == 0 && digit == 1) {
                break;
            }
            digit = number % 2;
            number /= 2;
            add = add << 1;
        }
        
        return origin + (add >> 1);
    }
}
/*
짝수는 (자기자신 + 1) 하면 비트가 1개 다르고, 자기자신보다 크면서 제일 작은 수가 된다.

5
-> 1
-> 0
-> 1
*/