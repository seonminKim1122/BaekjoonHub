import java.util.*;

class Solution {
    public int solution(int[] order) {
        Queue<Integer> main = new LinkedList<>();
        Stack<Integer> sub = new Stack<>();
        
        for (int i = 1; i <= order.length; i++) {
            main.add(i);
        }
            
        int idx = 0;
        int answer = 0;
        while (true) {
            boolean found = false;
            if (!sub.isEmpty() && sub.peek() == order[idx]) {
                sub.pop();
                answer++;
                idx++;
                found = true;
            } else {
                while (!main.isEmpty()) {
                    int temp = main.poll();
                    if (temp == order[idx]) {
                        idx++;
                        answer++;
                        found = true;
                        break;
                    }
                    else {
                        sub.push(temp);
                    }
                }
            }
            if (!found) break;
        }
        
        
        return answer;
    }
    
    
}

/*
메인 컨베이어 벨트 : 큐
보조 컨베이어 벨트 : 스택

order[now] -> 현재 영재가 실어야 하는 박스 번호

1. 보조의 peek 값 확인
2. 일치하면 pop
3. 일치하지 않으면 메인에 존재하는지 확인
*/