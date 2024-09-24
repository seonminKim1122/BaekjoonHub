class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int len = t.length();
        int size = p.length();
        
        for (int i = 0; i <= len - size; i++) {
            String sub = t.substring(i, i + size);
            if (Long.parseLong(sub) <= Long.parseLong(p)) answer++;
        }
        
        return answer;
    }
}