class Solution {
    public int[] solution(int[] array) {
        int max = -1;
        int idx = -1;
        
        int size = array.length;
        for (int i = 0; i < size; i++) {
            if (array[i] > max) {
                max = array[i];
                idx = i;
            }
        }
        
        int[] answer = {max, idx};
        return answer;
    }
}