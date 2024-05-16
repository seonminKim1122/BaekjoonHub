class Solution {
    
    
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, 0, target, 0);
        return answer;
    }
    
    
    int dfs(int[] numbers, int idx, int target, int value) {
        if (idx == numbers.length) {
            if (value == target) return 1;
            return 0;
        }
        
        return dfs(numbers, idx + 1, target, value + numbers[idx]) + dfs(numbers, idx + 1, target, value - numbers[idx]);
    }
}