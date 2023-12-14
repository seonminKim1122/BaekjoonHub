import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        HashMap<String, Integer> indexOfPlayers = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            indexOfPlayers.put(players[i], i);
            answer[i] = players[i];
        }
        
        for (String calling : callings) {
            int idx = indexOfPlayers.get(calling);
            answer[idx] = answer[idx - 1];
            answer[idx - 1] = calling;
            
            indexOfPlayers.put(answer[idx - 1], idx - 1);
            indexOfPlayers.put(answer[idx], idx);
        }
        
        return answer;
    }
}