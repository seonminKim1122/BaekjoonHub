import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        Stack<Integer> delivery = new Stack<>();
        Stack<Integer> pickup = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            delivery.push(deliveries[i]);
            pickup.push(pickups[i]);
        }
        init(delivery);
        init(pickup);
        
        while (!delivery.isEmpty() || !pickup.isEmpty()) {
            int temp1 = solve(cap, delivery);
            int temp2 = solve(cap, pickup);
            
            answer += Math.max(temp1, temp2) * 2;
        }
    
        
        return answer;
    }
    
    void init(Stack<Integer> stack) {
        while (!stack.isEmpty() && stack.peek() == 0) {
            stack.pop();
        }
    }
    
    int solve(int cap, Stack<Integer> stack) {
        int result = stack.size();
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (cap - v >= 0) {
                cap -= v;
            } else {
                stack.push(v - cap);
                break;
            }
        }
        return result;
    }
}

/*
현 시점에 배달/수거를 할 택배가 있는 가장 먼 집은 반드시 간다.
결국 가거나 돌아오는 과정에서 그 다음으로 먼집을 클리어 시키는 게 과제.
그래야 최소로 할 수 있음

1 0 3 1 2
0 3 0 4 0

cap: 4

total >= cap 이면 cap 만큼 트럭에 실고 가장 먼집까지 가는 길에 다 배달 때리면 됨.
2 + 1 + 3 > 4 이므로

1 0 2 0 0
0 3 0 0 0
*/