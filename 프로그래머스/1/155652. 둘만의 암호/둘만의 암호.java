class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for (int i = 0; i < s.length(); i++) {
            answer += change(s.charAt(i), index, skip);
        }
        
        return answer;
    }
    
    char change(char c, int index, String skip) {
        while (index > 0) {
            boolean isSkip = false;
            c = (char)('a' + (c + 1 - 'a') % 26);
            
            for (int i = 0; i < skip.length(); i++) {
                if (c == skip.charAt(i)) {
                    isSkip = true;
                    break;
                }    
            }    
        
            if (isSkip) continue;
            index--;
        }
        return c;
    }
}