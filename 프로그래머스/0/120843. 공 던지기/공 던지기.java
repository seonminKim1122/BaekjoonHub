class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        
        k--;
        int player = 1;
        while (k > 0) {
            player += 2;
            if (player > numbers.length) {
                player -= numbers.length;
            }
            k--;
        }
        
        answer = player;
        return answer;
    }
}