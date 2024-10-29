import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long temp1 = solve(applyPulseStartWithPlus(sequence));
        long temp2 = solve(applyPulseStartWithMinus(sequence));
        
        long answer = Math.max(temp1, temp2);
        return answer;
    }
    
    public int[] applyPulseStartWithPlus(int[] sequence) {
        int[] result = new int[sequence.length];
        for (int i = 0; i < sequence.length; i++) {
            if (i % 2 == 0) {
                result[i] = sequence[i];
            } else {
                result[i] = sequence[i] * -1;
            }
        }
        return result;
    }
    
    public int[] applyPulseStartWithMinus(int[] sequence) {
        int[] result = new int[sequence.length];
        for (int i = 0; i < sequence.length; i++) {
            if (i % 2 == 1) {
                result[i] = sequence[i];
            } else {
                result[i] = sequence[i] * -1;
            }
        }
        return result;
    }
    
    public long solve(int[] sequence) {
        long result = 0;
        long temp = 0;
        boolean wasPlus = true;
        boolean wasMinus = false;
        
        for (int number : sequence) {
            if (number >= 0 && wasMinus) {
                if (temp < 0) temp = 0;
                wasMinus = false;
                wasPlus = true;
            } else if (number < 0 && wasPlus) {
                result = Math.max(result, temp);
                wasPlus = false;
                wasMinus = true;
            }
            
            temp += number;
        }
        result = Math.max(result, temp);
        return result;
    }
}

/*
[2, -3, -6, -1, 3, 1, 2, -4]
[-2, 3, 6, 1, -3, -1, -2, 4]

answer = 0;
temp = 0;
wasPlus = true
wasMinus = false

- 가 + 를 만날 땐 temp 를 갱신
+ 가 - 를 만날 땐 answer 를 갱신

1. sequence[i] = 2, wasMinus false
- temp += 2
2. sequence[i] = -3, wasPlus true
- answer = Math.max(answer, temp) = 2
- temp += -3, wasPlus = false, wasMinus = true
3. sequence[i] = -6, wasPlus false
- temp += -6
4. sequence[i] = -1, wasPlus false
- temp += -1
5. sequence[i] = 3, wasMinus true
- temp = -8 < 0, temp = 3
- wasMinus false, wasPlus true
6. sequence[i] = 1, wasMinus false
- temp += 1
7. 
*/