class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        
        StringBuilder temp = new StringBuilder();
        for (char c : my_string.toCharArray()) {
            for (int i = 0; i < n; i++) {
                temp.append(c);
            }
        }
        
        answer = temp.toString();
        return answer;
    }
}