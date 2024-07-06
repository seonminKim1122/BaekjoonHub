import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = init(q1, queue1);
        long sum2 = init(q2, queue2);
        int N = (q1.size() + q2.size()) * 2;
        
        
        int answer = 0;   
        while (answer <= N) {
            if (sum1 > sum2) {
                int v = q1.poll();
                q2.add(v);
                sum2 += v;
                sum1 -= v;
            } else if (sum1 < sum2) {
                int v = q2.poll();
                q1.add(v);
                sum1 += v;
                sum2 -= v;
            } else {
                break;
            }
            answer++;
        }
        
        if (answer > N) answer = -1;
        
        return answer;
    }
    
    int init(Queue<Integer> to, int[] from) {
        int result = 0;
        for (int num : from) {
            to.add(num);
            result += num;
        }
        return result;
    }
}