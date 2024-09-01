class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        for (int ele : array) {
            if (ele > height) answer++;
        }
        return answer;
    }
}