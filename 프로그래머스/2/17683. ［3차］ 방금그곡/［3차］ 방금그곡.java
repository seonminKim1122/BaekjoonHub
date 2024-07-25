import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        
        String[] target = transform(m);
        int beforeDuration = -1;
        for (String musicinfo : musicinfos) {
            String[] infos = musicinfo.split(",");
            
            String title = infos[2];
            String[] melody = transform(infos[3]);
            int duration = calcDuration(infos[0], infos[1]);
            
            int time = 0;
            int length = melody.length;
            
            while (time < duration) {
                boolean isAnswer = true;
                for (int i = 0; i < target.length; i++) {
                    if (!target[i].equals(melody[(time + i) % length])) {
                        isAnswer = false;
                        break;
                    }
                }
                
                if (isAnswer) {
                    if (beforeDuration < duration) {
                        beforeDuration = duration;
                        answer=  title;
                    }
                    break;
                }
                
                time++;
            }
            
        }
        
        if (answer.equals("")) answer = "(None)";
        return answer;
    }
    
    int calcDuration(String start, String end) {
        String[] temp1 = start.split(":");
        String[] temp2 = end.split(":");
        
        int startTime = Integer.parseInt(temp1[0]) * 60 + Integer.parseInt(temp1[1]);
        int endTime = Integer.parseInt(temp2[0]) * 60 + Integer.parseInt(temp2[1]);
        
        return endTime - startTime;
    }
    
    String[] transform(String melody) {
        char[] melodies = melody.toCharArray();
        List<String> temp = new ArrayList<>();
        
        for (int i = 0; i < melodies.length; i++) {
            if (melodies[i] == '#') continue;
            String pitch = "";
            if (i + 1 < melodies.length && melodies[i + 1] == '#') {
                pitch += (melodies[i] + "" + melodies[i + 1]);
            } else {
                pitch += melodies[i];
            }
            temp.add(pitch);
        }
        
        String[] result = new String[temp.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = temp.get(i);
        }
        
        return result;
    }
    
}