import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> s = new LinkedHashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                s.add(numbers[i]+numbers[j]);
            }
        }

        answer = s.stream().mapToInt(i -> i).toArray();

        Arrays.sort(answer);
        return answer;
    }
}