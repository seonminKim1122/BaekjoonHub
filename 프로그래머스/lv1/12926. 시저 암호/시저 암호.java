class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(char c : s.toCharArray()) {
            if (c == ' ') {
                answer += c;
            } else if (c - 'a' >= 0 && c - 'a' <= 26) {
                answer += (char)((c - 'a' + n) % 26 + 97);
            } else if (c - 'A' >= 0 && c - 'A' <= 26) {
                answer += (char)((c - 'A' + n) % 26 + 65);
            }
        }
        return answer;
    }
}