class Solution {
    public String solution(String[] seoul) {
        int len = seoul.length;
        String x = "";
        
        for (int i = 0; i < len; i++) {
            if (seoul[i].equals("Kim")) {
                x = String.valueOf(i);
                break;
            }
        }
        String answer = "김서방은 x에 있다".replace("x", x);
        return answer;
    }
}