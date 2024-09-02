import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        PriorityQueue<String[]> todos = new PriorityQueue<>((s1, s2) -> s1[1].compareTo(s2[1]));
        Stack<String[]> waits = new Stack<>();
        for (String[] plan : plans) {
            todos.add(plan);
        }
        
        int idx = 0;
        String[] now = todos.poll();
        while (!todos.isEmpty()) {
            // 다음 해야 할 일
            String[] todo = todos.poll();
            
            int diff = calcDiff(now[1], todo[1]);
            int playtime = Integer.parseInt(now[2]);

            if (playtime <= diff) {
                // now 를 끝낸 경우
                answer[idx++] = now[0];
                
                int remain = diff - playtime;
                while (!waits.isEmpty() && remain > 0) {
                    String[] wait = waits.pop();
                    
                    int need = Integer.parseInt(wait[2]);
                    if (need > remain) {
                        wait[2] = String.valueOf(need - remain);
                        remain = 0;
                        waits.push(wait);
                    } else {
                        answer[idx++] = wait[0];
                        remain -= need;
                    }
                }
                
            } else {
                // now 를 못 끝낸 경우
                waits.push(new String[]{now[0], now[1], String.valueOf(playtime - diff)});
            }
            now = todo;
        }
        answer[idx++] = now[0];
        while (!waits.isEmpty()) {
            String[] wait = waits.pop();
            answer[idx++] = wait[0];
        }
        
        return answer;
    }
    
    
    int calcDiff(String start, String end) {
        String[] endTime = end.split(":");
        String[] startTime = start.split(":");
        
        int e = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]);
        int s = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
        
        return e - s;
    }
}