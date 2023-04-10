import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};

        Arrays.sort(strings, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.charAt(n) - s2.charAt(n) == 0 ? s1.compareTo(s2): s1.charAt(n) - s2.charAt(n);
            }
        });

        answer = strings;

        return answer;
    }
}