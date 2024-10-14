import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int work : works) {
            pq.add(work);
        }
        
        while (n > 0 && !pq.isEmpty()) {
            n--;
            int temp = pq.poll();
            if (temp == 1) continue;
            pq.add(temp - 1);
            
        }
        
        while (!pq.isEmpty()) {
            int temp = pq.poll();
            answer += (temp * temp);
        }
        
        return answer;
    }
}
/*
n 시간 동안 works 를 적절히 줄여서 야근 피로도를 최소로 만들기

x -> x - 1 로 줄일 때 효과 : 2x - 1

따라서 가장 큰 값을 줄여서 최대한 균등하게 만들자

PriorityQueue 사용하면 되지않을까?
*/