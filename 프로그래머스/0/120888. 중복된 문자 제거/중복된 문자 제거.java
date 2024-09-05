class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        int[] upperBucket = new int[26];
        int[] lowerBucket = new int[26];
        boolean whitespace = false;
        
        StringBuilder temp = new StringBuilder();
        for (char c : my_string.toCharArray()) {
            if ('A' <= c && c <= 'Z') {
                if (upperBucket[c - 'A'] > 0) continue;
                upperBucket[c - 'A']++;
            } else if ('a' <= c && c <= 'z') {
                if (lowerBucket[c - 'a'] > 0) continue;
                lowerBucket[c - 'a']++;
            } else {
                if (whitespace) continue;
                whitespace = true;
            }
            temp.append(c);
        }
        
        answer = temp.toString();
        return answer;
    }
}