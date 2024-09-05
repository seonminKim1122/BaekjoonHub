class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        int large = Math.max(sides[0], sides[1]);
        int small = Math.min(sides[0], sides[1]);
        
        int x = large - small + 1;
        while (x <= large && small + x > large) {
            answer++;
            x++;
        }
        
        x = large + 1;
        while (small + large > x) {
            x++;
            answer++;
        }
        
        return answer;
    }
}