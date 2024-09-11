class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int x = 1;
        answer = 1;
        while (x < n) {
            answer++;
            while (answer % 3 == 0 || String.valueOf(answer).contains("3")) {
                answer++;
            }
            x++;
        }
        
        return answer;
    }
}