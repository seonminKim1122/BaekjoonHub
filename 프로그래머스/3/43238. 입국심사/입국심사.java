class Solution {
    public long solution(int n, int[] times) {
        long start = 1;
        long end = calcEnd(n, times);
        
        long answer = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            
            long temp = solve(mid, times);
            if (temp >= n) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
    
    public long solve(long T, int[] times) {
        long result = 0;
        for (int time : times) {
            result += T / time;
        }
        return result;
    }
    
    public long calcEnd(int n, int[] times) {
        long min = times[0];
        for (int time : times) {
            min = Math.min(time, min);
        }
        return min * n;
    }
}
/*
end 의 시작값을 얼마로 할 것인가?
=> 제일 적게 걸리는 심사관으로 전부 처리하는 게 그나마 max -> min

=> 특정 시간에 대해 몇 명이 심사 받을 수 있는지를 계산
>= n 이면 시간을 줄이고
< n 이면 시간을 늘리고

시간 T
T // 7
T // 10
...

1번 calc => 100,000번 연산
log(1,000,000,000) = 30 정도
*/