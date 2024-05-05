class Solution {
    public int[] solution(int n, long left, long right) {
        // n * n 사이즈 배열을 1차원으로 변환
        // arr[i * n + j] = origin[i][j]
        // left = i * n + j 라고 하면 i = left // n, j = left % n
        // right = i * n + j 라고 하면 i = right // n, j = right % n
        // 그냥 left 부터 right 까지 배열 돌면서 i, j 를 구하고 j <= i 면 i 를 그렇지 않으면 0 을 채운다
        
        int[] answer = new int[(int)(right - left) + 1];
        for (long x = left; x <= right; x++) {
            int idx = (int)(x - left);
            
            int i = (int)(x / n);
            int j = (int)(x % n);
            
            if (j <= i) {
                answer[idx] = i + 1;
            } else {
                answer[idx] = j + 1;
            }
        }
        
        
        return answer;
    }
}

/*
1 2 3 4
2 2 3 4
3 3 3 4
4 4 4 4

실제로 2차원 다 채워버리면 메모리 초과 발생

i = left / n
j = left % n

if (j <= i) {
    value = i + 1;
} else {
    value = j + 1;
}
*/