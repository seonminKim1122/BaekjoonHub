class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        int N = a.length;
        int[] cnt = new int[N];
        
        int min = a[0];
        for (int i = 0; i < N; i++) {
            if (a[i] <= min) {
                min = a[i];
            } else {
                cnt[i]++;
            }
        }
        
        min = a[N - 1];
        for (int i = N - 1; i >= 0; i--) {
            if (a[i] <= min) {
                min = a[i];
            } else {
                cnt[i]++;
            }
        }
        
        for (int i = 0; i < N; i++) {
            if (cnt[i] < 2) answer++;
        }
        
        return answer;
    }
}
/*
i번째 숫자가 남기 위한 조건
1. 더 작은 걸 터뜨리는 행위를 하지 않을 때
-> (0 ~ i - 1) 풍선 중에 i보다 작은 게 없어야 함
-> (i + 1 ~ N - 1) 풍선 중에 i보다 작은 게 없어야 함

2. 더 작은 걸 터뜨리는 행위를 할 때
-> (0 ~ i - 1) 풍선은 상관 없고 , (i + 1) ~ (N - 1) 중엔 없어야 함
-> (0 ~ i - 1) 풍선 중에 i 보다 작은 게 없고, (i + 1) ~ (N - 1) 는 상관 없고

결론: (0 ~ i - 1) 중에 i 보다 작은 게 있고 (i + 1) ~ (N - 1) 중에 i 보다 작은 게 있는 경우 제외한 나머지 케이스 다 된다.

맨 앞, 맨 뒤는 무조건 남을 수 있다

[1, 2, 2, 2, 2, 0, 1, 1, 1, 1]

2 인 거 빼고 다 가능
min: -92
*/