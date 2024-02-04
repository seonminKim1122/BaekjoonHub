
import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length - 1;
        
        while (start <= end) {
            if (people[end] + people[start] <= limit) {
                end--;
                start++;
            } else {
                end--;
            }
            answer++;
        }
        
        return answer;
    }
}
/*
보트 최대 탑승 인원 2명
-> 무거운 사람, 가벼운 사람 매칭해서 태울 수 있는지 확인하기
*/