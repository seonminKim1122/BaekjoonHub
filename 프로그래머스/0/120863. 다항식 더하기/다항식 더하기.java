import java.util.*;

class Solution {
    public String solution(String polynomial) {
        String answer = "";
        
        String[] arr = polynomial.split(" ");
        
        int x = 0;
        int constant = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals("+")) continue;
            if (arr[i].contains("x")) {
                if (arr[i].charAt(0) == 'x') {
                    x++;
                } else {
                    x += Integer.parseInt(arr[i].substring(0, arr[i].length() - 1));
                }
            } else {
                constant += Integer.parseInt(arr[i]);
            }
        }
        
        boolean plusFlag = false;
        if (x > 0) {
            plusFlag = true;
            if (x > 1) {
                answer += String.valueOf(x) + "x";
            } else {
                answer += "x";
            }
        }
        
        if (constant != 0) {
            if (plusFlag) {
                answer += " + ";
            }
            answer += String.valueOf(constant);
        }
        
        return answer;
    }
}