import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        dartResult = dartResult.replaceAll("10","@");
        char[] calc = dartResult.toCharArray();
        Stack<Integer> point = new Stack<>();
        // 1S, 1S -> point
        // 2D, 2D -> tmp
        // *, tmp, 1S
        // 10 -> $
        for (char index : calc) {
            if (index - '0' >= 0 && index - '0' <= 9){
                point.push(index-'0');
            }
            else if (index == '@'){
                point.push(10);
            }
            else if (index == 'D'){
                point.push((int) Math.pow(point.pop(),2));
            }
            else if (index == 'T'){
               point.push((int) Math.pow(point.pop(),3));
            }
            else if (index == '#'){
                point.push(point.pop()*-1);
            }
            else if (index == '*'){
                if (!point.isEmpty()){
                    int tmp =  point.pop()*2;
                    if (!point.isEmpty()){
                        point.push(point.pop()*2);
                    }
                    point.push(tmp);
                }
            }
        }

        while (!point.isEmpty()){
            answer += point.pop();
        }

        return answer;
    }
}