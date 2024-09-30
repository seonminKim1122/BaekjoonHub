import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        List<Integer> temp = new ArrayList<>();
        for (long number = begin; number <= end; number++) {
            temp.add(findBlock(number));
        }
        
        int[] answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }
        
        return answer;
    }
    
    int findBlock(long number) {
        if (number == 1) return 0;
        long sqrt = (long)Math.sqrt(number);
        
        int result = 1;
        for (long i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                result = (int)i;
                if ((number / i) <= 10_000_000L) return (int)(number / i);
            }
        }
        
        return result;
    }
}
/*

칸 X 에 설치되는 블록은
X / 2, X / 3, ..., sqrt(X) 중 하나이다.

단 보유한 블록은 1 ~ 10,000,000 까지 이므로 X / 2 가 10,000,000 을 넘기는 경우
10,000,000 ~ sqrt(X) 이다.

만약 이 범위 안에서 나누어 떨어지는 값이 없다면 1 이 설치된다.

*/