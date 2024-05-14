import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        Set<String> words = new HashSet<>();
        Map<String, Integer> countOfstr1 = new HashMap<>();
        Map<String, Integer> countOfstr2 = new HashMap<>();
        
        
        int N = str1.length();
        for (int i = 0; i < N - 1; i++) {
            String word = str1.substring(i, i + 2);
            
            if (word.charAt(0) < 'A' || word.charAt(0) > 'Z') continue;
            if (word.charAt(1) < 'A' || word.charAt(1) > 'Z') continue;
            
            words.add(word);        
            countOfstr1.put(word, countOfstr1.getOrDefault(word, 0) + 1);
        }
        
        
        int M = str2.length();
        for (int i = 0; i < M - 1; i++) {
            String word = str2.substring(i, i + 2);
            
            if (word.charAt(0) < 'A' || word.charAt(0) > 'Z') continue;
            if (word.charAt(1) < 'A' || word.charAt(1) > 'Z') continue;

            words.add(word);
            countOfstr2.put(word, countOfstr2.getOrDefault(word, 0) + 1);
        }
        
        // 교집합 구하기
        int intersect = 0;
        for (String word : countOfstr1.keySet()) {
            
            int v1 = countOfstr1.get(word);
            int v2 = countOfstr2.getOrDefault(word, 0);
            
            if (v2 != 0) {
                intersect += Math.min(v1, v2);
            }
        }
        
        
        // 합집합 구하기
        int union = 0;
        for (String word : words) {
            int v1 = countOfstr1.getOrDefault(word, 0);
            int v2 = countOfstr2.getOrDefault(word, 0);
            
            union += Math.max(v1, v2);
        }
        
        if (union == 0) {
            return 65536;
        }
        
        answer = (int)(((double) intersect / union) * 65536);
        return answer;
    }
}

/*
HashMap 을 이용해서 각 문자열에 대해 Counting - map1, map2
-> 이 때 문자열들을 HashSet 에 넣어서 합집합 용 key 만들기

str1 에 있는 문자열 돌면서 교집합 크기 계산(Counting 값이 min 인 걸 선택)

합집합 용 key 돌면서 양 쪽에 잇으면 Counting 값이 max 인 걸 선택...

FR, RA, AN, NC, CE

FR, RE, EN, NC, CH
*/