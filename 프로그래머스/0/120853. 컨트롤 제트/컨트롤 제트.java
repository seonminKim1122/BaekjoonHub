class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] inputs = s.split(" ");
        
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i].equals("Z")) {
                answer -= Integer.parseInt(inputs[i - 1]);
                continue;
            }
            answer += Integer.parseInt(inputs[i]);
        }
        
        return answer;
    }
}