import java.util.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] temp = term.split(" ");
            String key = temp[0];
            int value = Integer.parseInt(temp[1]);
            
            map.put(key, value);
        }
        
        int idx = 1;
        for (String privacy : privacies) {
            String[] temp = privacy.split(" ");
            
            int period = map.get(temp[1]);
            
            int year = Integer.parseInt(temp[0].substring(0, 4));
            int month = Integer.parseInt(temp[0].substring(5, 7));
            int day = Integer.parseInt(temp[0].substring(8, temp[0].length()));
            
            month += period;

            year += (month - 1) / 12;
            month = (month - 1) % 12 + 1;
            day = day - 1;
            
            if (day == 0) {
                day = 28;
                month = month - 1;
                if (month == 0) {
                    month = 12;
                    year = year - 1;
                }
            }
            
            if (isOver(today, year, month, day)) {
                answer.add(idx);
            }
            idx++;
        }
        
        return answer;
    }
    
    public boolean isOver(String today, int y2, int m2, int d2) {
        int y1 = Integer.parseInt(today.substring(0, 4));
        int m1 = Integer.parseInt(today.substring(5, 7));
        int d1 = Integer.parseInt(today.substring(8, today.length()));
        
        if (y1 > y2) return true;
        if (y1 == y2 && m1 > m2) return true;
        if (y1 == y2 && m1 == m2 && d1 > d2) return true;
        
        return false;
    }
}

/*
2022 06 03
period = 18
2022 24 02
-> 2023 0 02
*/