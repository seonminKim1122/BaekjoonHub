class Solution {
    public boolean solution(String s) {
        int len = s.length();
        
        if (len != 4 && len != 6) {
            return false;
        }
        
        char c;
        for (int i = 0; i < len; i++) {
            c = s.charAt(i);
            if (c - '0' < 0 || c - '0' > 9) {
                return false;
            }
        }
        
        return true;
    }
}