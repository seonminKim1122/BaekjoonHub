import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0]);
        
        for (String[] time : book_time) {
            int start = toMinute(time[0]);
            int end = toMinute(time[1]);
            
            pq.add(new int[]{start, end});
        }
        
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int start = temp[0];
            int end = temp[1];
            
            if (rooms.isEmpty()) {
                rooms.add(end);
            } else {
                int fast = rooms.poll();
                if (fast + 10 > start) {
                    rooms.add(fast);   
                }
                rooms.add(end);
            }
        }
        
        return rooms.size();
    }
    
    int toMinute(String time) {
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }
}

/*

*/