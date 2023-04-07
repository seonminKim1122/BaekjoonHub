class Solution {
    public int[] solution(int[] arr, int divisor) {
        int size = 0;
        for (int num : arr) {
            if (num % divisor == 0) size++;
        }
        
        int[] answer;
        if (size == 0) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[size];
            
            int idx = 0;
            for (int num : arr) {
                if (num % divisor == 0) {
                    answer[idx++] = num;
                }
            }
            
            for (int i = 0; i < size-1; i++) {
                for (int j = 0; j < size-1; j++) {
                    int temp = answer[j];
                    if (temp > answer[j+1]) {
                        answer[j] = answer[j+1];
                        answer[j+1] = temp;
                    }
                }
            }
        }
        
        
        return answer;
    }
}