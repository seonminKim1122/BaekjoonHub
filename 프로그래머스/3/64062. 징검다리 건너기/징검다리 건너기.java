import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int start = 1;
        int end = 0;
        for (int stone : stones) {
            end = Math.max(end, stone);
        }
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            int temp = calc(stones, mid);
            
            if (temp <= k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        answer = end;
        return answer;
    }
    
    int calc(int[] stones, int n) {
        int result = 0;
        
        int start = 0;
        int end = 0;
        
        int temp = 0;
        while (end < stones.length) {
            if (stones[end] < n) {
                temp++;
                end++;
            } else {
                result = Math.max(result, temp);
                end = end + 1;
                start = end;
                temp = 0;
            }
        }
        result = Math.max(result, temp);
        
        return result + 1;
    }
}
/*
k를 고려하지 않았을 때 최대로 건널 수 있는 인원 수는 max(stones)

1 ~ max(stones) 중에 정답이 있다.

n 명이 건너기 위해서는 k 가 얼마어야 하는가? 를 따져서
<= k 면 인원을 늘리고
> k 면 인원을 줄여서 최대 인원을 찾는다.

n명이 건너기 위해서 k 가 얼마여야 하는지 구하기
=> n 미만인 값이 연속되는 구간의 최대 크기 + 1
*/