class Solution {
    
    static int answer = 0;
    static char[] chars = {'A', 'E', 'I', 'O', 'U'};
    static int index = 0;
    
    public int solution(String word) {
        char[] now = new char[5];
        dfs(0, now, word.toCharArray());
        return answer;
    }
    
    void dfs(int depth, char[] now, char[] word) {
        if (answer != 0) return;
        if (isEqual(now, word)) {
            answer = index;
            return;
        }
        if (depth == 5) return;
        
        for (int i = 0; i < 5; i++) {
            now[depth] = chars[i];
            index++;
            dfs(depth + 1, now, word);
            now[depth] = '\0';
        }
    }
    
    boolean isEqual(char[] now, char[] word) {
        for (int i = 0; i < word.length; i++) {
            if (now[i] != word[i]) return false;
        }
        return true;
    }
}

/*
A
AA
AAA

AAAA
AAAAA
AAAAE
AAAAI
AAAAO
AAAAU

AAAE
AAAEA
AAAEE
AAAEI
AAAEO
AAAEU
*/