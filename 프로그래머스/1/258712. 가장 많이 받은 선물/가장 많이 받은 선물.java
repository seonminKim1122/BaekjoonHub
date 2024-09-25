import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int N = friends.length;
        Map<String, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            idxMap.put(friends[i], i);
        }
        
        // 서로 주고 받은 선물 갯수 정보
        int[][] relation = new int[N][N];
        for (String gift : gifts) {
            String[] temp = gift.split(" ");
            int from = idxMap.get(temp[0]);
            int to = idxMap.get(temp[1]);
            
            relation[from][to]++;
        }
        
        // 선물지수 계산
        int[] giftIndex = new int[N];
        for (int i = 0; i < N; i++) {
            int send = 0;
            int receive = 0;
            for (int j = 0; j < N; j++) {
                send += relation[i][j];
                receive += relation[j][i];
            }
            giftIndex[i] = send - receive;
        }
        
        int[] next = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (relation[i][j] > relation[j][i]) next[i]++;
                else if (relation[i][j] == relation[j][i] || (relation[i][j] == 0 && relation[j][i] == 0)) {
                    if (giftIndex[i] > giftIndex[j]) next[i]++;
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, next[i]);
        }
        
        return answer;
    }
}