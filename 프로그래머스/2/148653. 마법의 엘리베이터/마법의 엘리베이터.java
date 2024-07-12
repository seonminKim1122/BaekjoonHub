class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        answer = solve(storey);
        
        return answer;
    }
    
    public int solve(int storey) {
        if (storey < 10) return Math.min(storey, 10 - storey + 1);
        
        int v = storey % 10;
        
        int temp1 = solve(storey / 10); // 내림
        int temp2 = solve(storey / 10 + 1); // 올림
        
        return Math.min(temp1 + v, temp2 + 10 - v);
    }
}
/*

163
-> 16 + 3 / 17 + 7
-> 1 + 6 + 3 / 2 + 4 + 3 / 1 + 7 + 7 / 2 + 3 + 7
*/