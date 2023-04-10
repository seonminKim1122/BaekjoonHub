import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int flagNum = arr[0];
        int arrSize = arr.length;
        ArrayList<Integer> tempAnswer = new ArrayList<>();
        tempAnswer.add(arr[0]);

        for (int i = 1; i < arrSize; i++) {
            if (arr[i] != flagNum) {
                tempAnswer.add(arr[i]);
                flagNum = arr[i];
            }
        }

        int[] answer = new int[tempAnswer.size()];
        int idx = 0;
        for (int num : tempAnswer) {
            answer[idx++] = num;
        }

        return answer;
    }
}