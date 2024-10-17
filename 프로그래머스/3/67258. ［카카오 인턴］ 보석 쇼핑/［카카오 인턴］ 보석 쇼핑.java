import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Map<String, Integer> count = new HashMap<>();
        for (String gem : gems) {
            count.put(gem, 0);
        }
        
        int[] answer = {0, gems.length - 1};
        
        int kinds = count.keySet().size();
        int contains = 0; // 현재 구간에서 gem 종류를 몇 개 포함하고 있는지

        int start = 0;
        int end = 0;
        int size = gems.length;
        while (end < size) {
            if (contains < kinds) {
                // 현재 구간에 포함되지 않은 보석 종류 존재
                String gem = gems[end];
                if (count.get(gem) == 0) contains++;
                count.put(gem, count.get(gem) + 1);
                end++;
            } else {
                // 현재 구간이 모든 보석 종류를 포함
                if (answer[1] - answer[0] > end - 1 - start) {
                    answer[0] = start;
                    answer[1] = end - 1;
                }
                
                String gem = gems[start];
                count.put(gem, count.get(gem) - 1);
                if (count.get(gem) == 0) contains--;
                start++;
            }
        }
        
        // 마지막 칸 탐색 시점에 보석 종류가 다 등장하는 경우 => start 줄이면서 check
        while (contains >= kinds) {
            if (answer[1] - answer[0] > end - 1 - start) {
                answer[0] = start;
                answer[1] = end - 1;
            }
            
            String gem = gems[start];
            count.put(gem, count.get(gem) - 1);
            if (count.get(gem) == 0) contains--;
            start++;
        }
        
        answer[0]++;
        answer[1]++;
        return answer;
    }
}
/*
1. 진열된 보석 종류 파악
2. 투 포인터 활용
- end 포인트 늘려가면서 보석 종류 별 등장 횟수 체크
- 모든 보석 종류가 등장하면 해당 start, end 를 이전과 비교해서 구간이 더 짧으면 업데이트
    - 구간의 크기가 동일한 경우 시작 지점이 더 작으면 업데이트
- 모든 보석 종류가 등장하지 않는 시점까지 start 를 줄임

- 위 과정 반복!
*/