import java.util.*;
class Solution {
    public int[] solution(int[] answers) {        int[] answer = {};
        List<Integer> tmp = new ArrayList<>();
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


        int correctA = 0;
        int correctB = 0;
        int correctC = 0;

        for (int i = 0; i < answers.length; i++) {
            if (a[i%5] == answers[i])
                correctA++;
            if (b[i%8] == answers[i])
                correctB++;
            if (c[i%10] == answers[i])
                correctC++;
        }

        int max = Math.max(correctA, Math.max(correctB,correctC));
        
        if (max == correctA){
            tmp.add(1);
        }
        if (max == correctB){
            tmp.add(2);
        }
        if (max == correctC){
            tmp.add(3);
        }
        answer = tmp.stream().mapToInt(i -> i).toArray();
        return answer;
        
    }
}