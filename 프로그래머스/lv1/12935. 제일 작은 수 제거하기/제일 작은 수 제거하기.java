class Solution {
    public int[] solution(int[] arr) {
        int len = arr.length;
        if (len == 1) {return new int[]{-1};}

        int minIdx = 0;
        int min = arr[0];

        int[] answer = new int[len-1];

        // 최소값의 인덱스 찾기
        for (int i = 1; i < len; i++) {
            if (min > arr[i]) {
                minIdx = i;
                min = arr[i];
            }
        }

        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (i == minIdx) continue;
            answer[idx++] = arr[i];
        }

        return answer;
    }
}