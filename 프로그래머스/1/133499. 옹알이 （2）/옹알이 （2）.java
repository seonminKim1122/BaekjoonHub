class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] words = {"aya", "ye", "woo", "ma"};
        
        for (String babble : babbling) {
            if (canSpeak(words, babble)) answer++;
        }
        
        return answer;
    }
    
    
    boolean canSpeak(String[] words, String target) {
        int before = -1;
        int idx = 0;
        
        while (idx < target.length()) {
            boolean okay = false;
            for (int i = 0; i < 4; i++) {
                String word = words[i];
                if (idx + word.length() > target.length()) continue;
                
                String temp = target.substring(idx, idx + word.length());
                if (temp.equals(word)) {
                    if (before == i) return false;
                    idx += word.length();
                    okay = true;
                    before = i;
                    break;
                }
            }

            if (!okay) return false;
        }
        
        return true;
    }
}