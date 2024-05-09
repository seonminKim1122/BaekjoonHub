import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        
        int N = progresses.length;
        int[] days = new int[N];
        for (int i = 0; i < N; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            
            days[i] = (100 - progress) / speed + ((100 - progress) % speed != 0 ? 1 : 0);
        }
        
        int criteria = days[0];
        int cnt = 1;
        
        List<Integer> temp = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            if (days[i] <= criteria) {
                cnt++;
            } else {
                temp.add(cnt);
                cnt = 1;
                criteria = days[i];
            }
        }
        temp.add(cnt);
        
        int[] answer = new int[temp.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = temp.get(i);
        }
        
        return answer;
    }
}

/*
93, 30, 55

가장 먼저 있는 작업이 언제 배포되는지 계산

93 -> speed : 1, day: (100 - 93) / 1 + ((100 - 93) % 1 == 0 ? 0 : 1) = 7
30 -> speed : 30, day: (100 - 30) / 30 + ((100 - 30) % 30 == 0 ? 0 : 1) = 3 < 7 이니까 7에 같이 배포
55 -> speed: 5, day: (100 - 55) / 5 + ((100 - 55) % 5 == 0 ? 0 : 1) = 9 > 7 이니까 9 에 배포, 기준 9로 변경



*/