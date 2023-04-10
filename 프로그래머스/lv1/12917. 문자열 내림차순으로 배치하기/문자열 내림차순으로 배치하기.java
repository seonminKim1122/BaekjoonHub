import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        char[] a = s.toCharArray();

        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();
        for (char i: a) {
            sb.append(i);
        }
        sb.reverse();

        answer = sb.toString();
        System.out.println(answer);
        return answer;
    }
}