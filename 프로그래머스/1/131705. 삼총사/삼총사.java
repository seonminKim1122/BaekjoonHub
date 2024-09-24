class Solution {
    public int solution(int[] number) {
        int answer = solve(0, 0, new int[3], number);
        return answer;
    }
    
    int solve(int depth, int start, int[] path, int[] number) {
        if (depth == 3) {
            if ((path[0] + path[1] + path[2]) == 0) return 1;
            return 0;
        }
        
        int result = 0;
        for (int i = start; i < number.length; i++) {
            path[depth] = number[i];
            result += solve(depth + 1, i + 1, path, number);
        }
        return result;
    }
}