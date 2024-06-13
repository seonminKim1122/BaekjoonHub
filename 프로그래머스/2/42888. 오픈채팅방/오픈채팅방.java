import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> map = new HashMap<>();
        for (String temp : record) {
            String[] words = temp.split(" ");
            
            String info = words[0];
            if (info.equalsIgnoreCase("leave")) continue;
            
            String id = words[1];
            String name = words[2];
            
            map.put(id, name);
        }
        
        int idx = 0;
        List<String> tempAnswer = new ArrayList<>();
        for (String temp : record) {
            String[] words = temp.split(" ");
            
            String info = words[0];
            String id = words[1];
            
            if (info.equalsIgnoreCase("enter")) {
                tempAnswer.add(map.get(id) + "님이 들어왔습니다.");
            } else if (info.equalsIgnoreCase("leave")) {
                tempAnswer.add(map.get(id) + "님이 나갔습니다.");
            }
        }
        
        String[] answer = new String[tempAnswer.size()];
        for (int i = 0; i < tempAnswer.size(); i++) {
            answer[i] = tempAnswer.get(i);
        }
        
        return answer;
    }
}

/*
uid : Name  -> key : value 로 저장
마지막까지 다 체크해서 uid 에 value 로는 최종 닉네임을 저장

record 배열 돌면서 uid 로 value 꺼내서 데이터 기록

*/