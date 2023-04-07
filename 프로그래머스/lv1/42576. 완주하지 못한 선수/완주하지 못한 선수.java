import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {

        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);

        int len = completion.length;

        for (int i = 0; i < len; i++) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }

        if (answer.equals("")) {answer = participant[len];}
        return answer;
        
    }
}