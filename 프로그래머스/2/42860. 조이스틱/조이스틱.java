class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int N = name.length();
        int horizontal = init(name);
        
        int left = 0;
        for (int right = 0; right < N; right++) {
            if (name.charAt(right) == 'A') continue;
            // left < < right 은 'A'
            
            int temp1 = left + (N - (right - left));
            int temp2 = (N - right) * 2 + left; 
            
            
            horizontal = Math.min(horizontal, Math.min(temp1, temp2));
            answer += upDown(name.charAt(right));
            left = right;
        }
        System.out.println(horizontal);
        answer += horizontal;
        return answer;
    }
    
    int init(String name) {
        int N = name.length();
        for (int i = N - 1; i >= 0; i--) {
            if (name.charAt(i) == 'A') continue;
            return i;
        }
        return 0;
    }
    
    int upDown(char target) {
        if ('A' <= target && target <= 'N') return target - 'A';
        return 'Z' - target + 1;
    }
}
/*
XXX AAAAA XX AA XX AAA XX AAAA

1) A 의 왼쪽 끝을 먼저 갔다가 오른쪽 끝으로 갈 건지
2) A 의 오른쪽 끝을 먼저 갔다가 왼쪽 끝으로 갈 건지

둘 중 하나!
*/