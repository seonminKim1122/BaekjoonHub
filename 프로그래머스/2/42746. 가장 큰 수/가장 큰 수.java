import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        int N = numbers.length;
        List<MyNumber> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(new MyNumber(numbers[i]));
        }
        
        Collections.sort(arr);
        
        for (int i = N - 1; i >= 0; i--) {
            answer += arr.get(i).number;
        }
        
        if (answer.charAt(0) == '0') answer = "0";
        
        return answer;
    }
    
    class MyNumber implements Comparable<MyNumber> {
        
        String number;
        
        MyNumber(int number) {
            this.number = String.valueOf(number);
        }
        
        @Override
        public int compareTo(MyNumber other) {
            int v1 = Integer.parseInt(this.number + other.number);
            int v2 = Integer.parseInt(other.number + this.number);
            
            if (v1 > v2) return 1;
            if (v2 > v1) return -1;
            return 0;
        }
    }
}

/*
기본
1. 맨 앞의 숫자가 가장 큰 놈이 제일 큰 숫자다.
2. 맨 앞의 숫자가 똑같다면 그 다음 숫자가 가장 큰 놈이 제일 큰 숫자다.

※ 3, 30 은 어떻게 처리해야 할까?
※ 30, 302 은 어떻게 처리해야 할까?

302 30
30 302

303 30
30 303

그냥 실제로 붙여보는 방식이 제일 정확하지 않는가?

*/
