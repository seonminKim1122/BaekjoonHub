import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = solve(begin, target, words);    
        return answer;
    }
    
    int solve(String begin, String target, String[] words) {
        int N = words.length;
        
        Queue<Word> queue = new LinkedList<>();
        boolean[] visit = new boolean[N];
        queue.add(new Word(begin, 0));
        
        while (!queue.isEmpty()) {
            Word now = queue.poll();
            
            if (now.word.equals(target)) {
                return now.cnt;
            }
            
            for (int i = 0; i < N; i++) {
                if (!visit[i] && canExchange(now.word, words[i])) {
                    queue.add(new Word(words[i], now.cnt + 1));
                    visit[i] = true;
                }
            }
        }
        
        return 0;
    }
    
    boolean canExchange(String from, String to) {
        int N = from.length();
        int temp = 0;
        for (int i = 0; i < N; i++) {
            if (from.charAt(i) != to.charAt(i)) temp++;
        }
        return temp <= 1;
    }
}

class Word {
    String word;
    int cnt;
    
    Word(String word, int cnt) {
        this.word = word;
        this.cnt = cnt;
    }
}