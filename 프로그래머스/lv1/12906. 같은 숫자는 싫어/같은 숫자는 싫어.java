import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> a = new ArrayList<>();

        a.add(arr[0]);
        int firstNum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != firstNum) {
                a.add(arr[i]);
                firstNum = arr[i];
            }
        }
        int[] answer = a.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}