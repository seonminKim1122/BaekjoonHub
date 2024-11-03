import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] times = covert(timetable);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int time : times) {
            pq.add(time);
        }
        
        int bus = convertStringToInt("09:00");
        while (n > 1) {
            int remain = m;
            while (!pq.isEmpty() && pq.peek() <= bus) {
                pq.poll();
                remain--;
                if (remain == 0) break;
            }
            bus += t;
            n--;
        }
        
        int last = 0;
        while (!pq.isEmpty() && pq.peek() <= bus) {
            last = pq.poll();
            m--;
            if (m == 0) break;
        }
        
        String answer = "";
        if (m == 0) {
            answer = convertIntToString(last - 1);
        } else {
            answer = convertIntToString(bus);
        }
        
        return answer;
    }
    
    public String convertIntToString(int time) {
        int hour = time / 60;
        int minute = time % 60;
        
        String resultHour = "";
        String resultMinute = "";
        if (hour < 10) {
            resultHour += "0";
        }
        if (minute < 10) {
            resultMinute += "0";
        }
        resultHour += hour;
        resultMinute += minute;
        return resultHour + ":" + resultMinute;
    }
    
    public int convertStringToInt(String time) {
        String[] temp = time.split(":");
        int hour = Integer.parseInt(temp[0]);
        int minute = Integer.parseInt(temp[1]);
        return hour * 60 + minute;
    }
    
    public int[] covert(String[] timetable) {
        int N = timetable.length;
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = convertStringToInt(timetable[i]);
        }
        return result;
    }
}
/*
PriorityQueue
-> 도착시간 순으로, 

n = 1 일 때 09:00 에 버스가 도착
PriorityQueue 에서 해당 버스에 탈 수 있는 인원 제거

m 이 다 차면 다음 버스
n = 2...

n 이 마지막 일 때
pq 에서 해당 버스에 탈 수 있는 인원 제거 하는데 인원이 m 이상이면
m 번째 인원보다 1분 빨리 서면 된다.

m 미만이면 버스가 출발하는 시간에 서면 된다.
*/