class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        int[] bucket = new int[1000];
        for (int number : array) {
            bucket[number]++;
        }
        
        answer = solve(bucket);
        return answer;
    }
    
    public int solve(int[] bucket) {
        // 최빈값... 찾되 최빈값이 여러 개면 -1...
        
        // 최빈값 찾기
        int len = bucket.length;
        int maxCnt = 0;
        int result = -1;
        for (int i = 0; i < len; i++) {
            if (bucket[i] > maxCnt) {
                result = i;
                maxCnt = bucket[i];
            }
        }
        
        // 여러 개인지 확인
        int temp = 0;
        for (int i = 0; i < len; i++) {
            if (bucket[i] == maxCnt) {
                temp++;
            }
        }
        
        return temp > 1 ? -1: result;
    }
}