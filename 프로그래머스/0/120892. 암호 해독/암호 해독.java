class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        
        int size = cipher.length();
        for (int i = 0; i < size; i++) {
            if ((i + 1) % code == 0) {
                answer += cipher.charAt(i);
            }
        }
        return answer;
    }
}