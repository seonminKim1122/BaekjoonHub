class Solution {
    public int solution(String s) {
        int answer = 0;
        
        
        
        while (s.length() > 0) {
            int cnt1 = 0;
            int cnt2 = 0;
            char x = s.charAt(0);

            boolean isContinue = false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == x) cnt1++;
                else cnt2++;
            
                if (cnt1 == cnt2) {
                    s = s.substring(i + 1, s.length());
                    isContinue = true;
                    break;
                }
            }
            answer++;
            if (!isContinue) break;
        }
        

        
        return answer;
    }
}