import java.util.*;

class Solution {
    public int[] solution(String[] infos, String[] query) {
        Map<String, List<Integer>> map = new HashMap<>();
        init(map, infos);
        
        int numOfQueries = query.length;
        int[] answer = new int[numOfQueries];
        
        for (int i = 0; i < numOfQueries; i++) {
            String[] q = query[i].split(" and ");
            String[] temp = q[3].split(" ");
            
            String language = q[0].trim();
            String position = q[1].trim();
            String career = q[2].trim();
            String soulFood = temp[0].trim();
            
            int criteria = Integer.parseInt(temp[1]);
            
            String key = createKey(language, position, career, soulFood);
            List<Integer> scores = map.get(key);
            answer[i] = calc(scores, criteria);
        }
        
        return answer;
    }
    
    int calc(List<Integer> scores, int criteria) {
        int size = scores.size();
        int start = 0;
        int end = size - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            int score = scores.get(mid);
            if (score < criteria) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return size - start;
    }
    
    void init(Map<String, List<Integer>> map, String[] infos) {
        String[] languages = {"cpp", "java", "python", "-"};
        String[] positions = {"backend", "frontend", "-"};
        String[] careers = {"junior", "senior", "-"};
        String[] soulFoods = {"chicken", "pizza", "-"};
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        String key = createKey(languages[i], positions[j], careers[k], soulFoods[l]);
                        map.put(key, new ArrayList<>());
                    }
                }
            }
        }
        
        for (String info : infos) {
            String[] temp = info.split(" ");
            
            String[] languages2 = {temp[0], "-"};
            String[] positions2 = {temp[1], "-"};
            String[] careers2 = {temp[2], "-"};
            String[] soulFoods2 = {temp[3], "-"};
            
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 2; k++) {
                        for (int l = 0; l < 2; l++) {
                            String key = createKey(languages2[i], positions2[j], careers2[k], soulFoods2[l]);
                            map.get(key).add(Integer.parseInt(temp[4]));
                        }
                    }
                }
            }
        }
        
        for(String key : map.keySet()) {
            List<Integer> value = map.get(key);
            Collections.sort(value);
        }
    }
    
    String createKey(String language, String position, String career, String soulFood) {
        StringBuilder key = new StringBuilder();
        key.append(language);
        key.append(" and ").append(position);
        key.append(" and ").append(career);
        key.append(" and ").append(soulFood);
        return key.toString();
    }
}
/*
개발언어 / 직군 / 경력 / 소울푸드
를 기준으로 해당 인원이 검색될 수 있는 쿼리는 총 16가지 경우의 수

java - - - 
- backend - -
...

java backend junior chicken

사전 작업 : 50000 * 16 = 800000

실제 검색 HashMap 이용 query 를 key 로 사용자 리스트 얻고 
해당 리스트에서 점수 기준 over 되는 인원 counting
=> full scan 해도 50000
*/