class Solution {
    public String solution(String s, int n) {
        String answer = "";

        for(char c : s.toCharArray()) {
            if (c == ' ') {
                answer += c;
            } else if (0 <= c-'A' && c-'A' <= 26) {
                answer += (char)((c - 'A' + n) % 26 + 'A');
            } else {
                answer += (char)((c - 'a' + n) % 26 + 'a');
            }
        }
        return answer;
    }
}