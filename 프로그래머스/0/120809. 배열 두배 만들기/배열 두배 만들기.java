class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            answer[i] = numbers[i] * 2;
        }
        return answer;
    }
}