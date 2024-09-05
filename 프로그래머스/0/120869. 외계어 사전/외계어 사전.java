class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        
        int[] spellBucket = makeBucket(spell);
        for (String word : dic) {
            int[] wordBucket = makeBucket(word);
            if (isSame(spellBucket, wordBucket)) {
                answer = 1;
                break;
            }
        }
        
        return answer;
    }
    
    int[] makeBucket(String[] spell) {
        int[] bucket = new int[26];
        for (String s : spell) {
            char ch = s.toCharArray()[0];
            bucket[ch - 'a']++;
        }
        return bucket;
    }
    
    int[] makeBucket(String dic) {
        int[] bucket = new int[26];
        for (char ch: dic.toCharArray()) {
            bucket[ch - 'a']++;
        }
        return bucket;
    }
    
    boolean isSame(int[] bucket1, int[] bucket2) {
        for (int i = 0; i < 26; i++) {
            if (bucket1[i] != bucket2[i]) return false;
        }
        return true;
    }
}