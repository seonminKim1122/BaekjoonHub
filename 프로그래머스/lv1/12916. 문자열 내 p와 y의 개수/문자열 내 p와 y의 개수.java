class Solution {
    boolean solution(String s) {
        int len = s.length();
        int countP = 0;
        int countY = 0;
        char c;
        
        for (int i = 0; i < len; i++) {
            c = s.charAt(i);
            
            if (c == 'p' || c == 'P') {
                countP++;
            } else if (c == 'y' || c == 'Y') {
                countY++;
            }
        }

        boolean answer = (countP == countY);
        return answer;
    }
}