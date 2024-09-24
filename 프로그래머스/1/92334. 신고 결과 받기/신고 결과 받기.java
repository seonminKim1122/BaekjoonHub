import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] reports, int k) {
        // id_list 를 통해 각 사람의 고유 idx 를 파악한다.
        Map<String, Integer> idxMap = new HashMap<>();
        int N = id_list.length;
        for (int i = 0; i < N; i++) {
            idxMap.put(id_list[i], i);
        }
        
        // a의 b 신고 여부만 따지는 boolean 배열 생성
        boolean[][] relation = new boolean[N][N];
        for (String report : reports) {
            String[] temp = report.split(" ");
            
            int from = idxMap.get(temp[0]);
            int to = idxMap.get(temp[1]);
            
            relation[from][to] = true;
        }
        
        // 이용자 별로 신고당한 횟수 파악
        int[] reportedCnts = new int[N];
        for (int j = 0; j < N; j++) {
            int temp = 0;
            for (int i = 0; i < N; i++) {
                if (relation[i][j]) temp++;
            }
            reportedCnts[j] = temp;
        }
        
        // 각 이용자별로 내가 신고한 이용자 중 신고당한 횟수가 2이상인 사람의 수 파악
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            int temp = 0;
            for (int j = 0; j < N; j++) {
                if (relation[i][j] && reportedCnts[j] >= k) temp++;
            }
            answer[i] = temp;
        }
        
        
        return answer;
    }
}