class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        String[] formular = my_string.split(" ");
        
        answer = Integer.parseInt(formular[0]);
        
        String operator = "";
        for (int i = 1; i < formular.length; i++) {
            if (formular[i].equals("+") || formular[i].equals("-")) {
                operator = formular[i];
                continue;
            }
            
            if (operator.equals("+")) {
                answer += Integer.parseInt(formular[i]);
            } else {
                answer -= Integer.parseInt(formular[i]);
            }
        }
        
        return answer;
    }
}