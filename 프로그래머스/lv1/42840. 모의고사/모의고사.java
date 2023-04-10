import java.util.*;
class Solution {
    public int[] solution(int[] answers) {        int[] answer = {};
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int answersLength = answers.length;
        int patternsLength = patterns.length;
        int[] temp = new int[3];
        for (int i = 0; i < answersLength; i++) {
            for (int j = 0; j < patternsLength; j++) {
                if (answers[i] == patterns[j][i % patterns[j].length]){
                    temp[j]++;
                }
            }
        }

        int max = Math.max(Math.max(temp[0], temp[1]), temp[2]);
        List<Integer> list = new ArrayList<>();
        int i = 1;
        for(int num : temp) {
            if (max == num) {
                list.add(i);
            }
            i++;
        }

        i = 0;
        int[] result = new int[list.size()];
        for(int num : list) {
            result[i++] = num;
        }

        return result;
        
    }
}