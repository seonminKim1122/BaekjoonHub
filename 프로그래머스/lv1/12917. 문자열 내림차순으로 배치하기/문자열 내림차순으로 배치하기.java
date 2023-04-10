import java.util.*;
class Solution {
    public String solution(String s) {
        String[] temp = s.split("");
        Arrays.sort(temp, Comparator.reverseOrder());
        return String.join("", temp);
    }
}