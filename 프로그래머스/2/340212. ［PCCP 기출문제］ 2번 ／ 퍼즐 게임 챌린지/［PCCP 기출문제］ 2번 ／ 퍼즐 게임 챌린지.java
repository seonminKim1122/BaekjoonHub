class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int start = 1;
        int end = max(diffs);
        
        while (start <= end) {
            int mid = (start + end) / 2;
            long temp = calculateTime(diffs, times, mid);
            
            if (temp > limit) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        answer = start;
        return answer;
    }
    
    int max(int[] arr) {
        int result = arr[0];
        for (int ele : arr) {
            if (ele > result) result = ele;
        }
        return result;
    }
    
    long calculateTime(int[] diffs, int[] times, int level) {
        int N = diffs.length;
        
        long result = 0;
        for (int i = 0; i < N; i++) {
            int diff = diffs[i];
            int time = times[i];
            
            if (diff > level) {
                result += (diff - level) * (times[i] + times[i - 1]) + times[i];
            } else {
                result += times[i];
            }
        }
        
        return result;
    }
}