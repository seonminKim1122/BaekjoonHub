import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        
        HashSet<String> said = new HashSet<>();
        said.add(words[0]);
        int person = 1;
        int turn = 1;
        boolean fail = false;
        
        for (int i = 1; i < words.length; i++) {
            person++;
            if (person == n + 1) {
                person %= n;
                turn += 1;
            }
            
            String before = words[i - 1];
            String now = words[i];
            if (said.contains(now)) { // 이미 말한 단어면 실패
                fail = true;
                break;
            }
            
            if (before.charAt(before.length() - 1) != now.charAt(0)) { // 끝말 잇기가 안 되면 실패
                fail = true;
                break;
            }
            said.add(now);
        }
        
        int[] answer = new int[2];
        if (fail) {
            answer[0] = person;
            answer[1] = turn;
        }
        return answer;
    }
}