import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, Integer> lastInInfo = new HashMap<>();
        Map<String, Integer> cumulativeTime = new HashMap<>();
        int lastTime = timeToInt("23:59");
        
        for (String record : records) {
            String[] infos = record.split(" ");
            
            int time = timeToInt(infos[0]);
            String car = infos[1];
            String inOut = infos[2];
            
            if (inOut.equals("IN")) {
                lastInInfo.put(car, time);
            } else {
                int sum = cumulativeTime.getOrDefault(car, 0) + (time - lastInInfo.get(car));
                cumulativeTime.put(car, sum);
                lastInInfo.put(car, lastTime);
            }
        }
        
        List<String> sortedCarNums = new ArrayList<>();
        for (String car : lastInInfo.keySet()) {
            sortedCarNums.add(car);
            int sum = cumulativeTime.getOrDefault(car, 0) + (lastTime - lastInInfo.get(car));
            cumulativeTime.put(car, sum);
        }
        
        Collections.sort(sortedCarNums);
        
        int N = sortedCarNums.size();
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            String car = sortedCarNums.get(i);
            int time = cumulativeTime.get(car);
            answer[i] = calcFee(time, fees);
        }
        
        
        return answer;
    }
    
    int timeToInt(String time) {
        String[] info = time.split(":");
        int hour = Integer.parseInt(info[0].strip());
        int minute = Integer.parseInt(info[1].strip());
        return 60 * hour + minute;
    }
    
    int calcFee(int minute, int[] fees) {
        if (minute - fees[0] <= 0) return fees[1];
        
        int q = (minute - fees[0]) / fees[2];
        int r = (minute - fees[0]) % fees[2];
        if (r != 0) q++;
        
        return fees[1] + q * fees[3];
    }
}