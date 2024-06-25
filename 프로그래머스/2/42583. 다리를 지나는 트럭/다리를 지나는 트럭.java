import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        int onBridgeWeight = 0; // 다리 위에 올라가있는 트럭 무게 합
        int onBridgeCnt = 0; // 다리 위에 올라가있는 트럭 수

        Queue<int[]> bridge = new LinkedList<>();
        for (int truck: truck_weights) {
            if (!bridge.isEmpty() && answer >= bridge.peek()[1]) {
                int[] out = bridge.poll();
                onBridgeWeight -= out[0];
                onBridgeCnt--;
            }

            while ((onBridgeWeight + truck > weight) || (onBridgeCnt >= bridge_length)) {
                int[] out = bridge.poll();
                onBridgeWeight -= out[0];
                onBridgeCnt--;
                answer = out[1] - 1;
            }

            onBridgeWeight += truck;
            onBridgeCnt++;
            answer++;
            bridge.add(new int[]{truck, answer + bridge_length});
        }

        while (!bridge.isEmpty()) {
            int[] out = bridge.poll();
            answer = out[1];
        }

        return answer;
    }
}
/*
bridge_length : 다리의 길이(다리 길이보다 더 많은 수의 트럭이 다리에 올라갈 수는 없다)
weight : 다리가 버티는 무게(버티는 무게보다 더 무겁게 트럭이 다리 위에 올라갈 수는 없다)

트럭이 다리에서 나오는 시간 : 다리에 올라간 시간 + bridge_length

현재 대기 트럭을 다리에 올릴 수 없는 상황이라면
가능할 때까지 트럭을 다리에서 통과시켜야 한다.
*/